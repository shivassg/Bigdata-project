import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class StubReducer extends Reducer<Text, Text, Text, RoutesInfo> {
	
	static int counter = 0;

  @Override
  public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
	  
	  //For each key, we are going to construct a 24 index array. And in each 
	  //String keyID = "10,1048";
	  
	  HashMap <String, int[]> map = new HashMap<String, int[]>();
	  
	  float[] hoursArray = new float[24];
	  int[] count = new int[24];
	  
	  //if(key.compareTo((keyID).getBytes(), 0, keyID.length()) ==0) {
		  
		  for(Text hodAndTravelTime : values){
			  
			  //System.out.println((hodAndTravelTime).toString()) ;
			  String hodAndTT = ((hodAndTravelTime).toString()) ;
			  String[] hodAndTTArray =  hodAndTT.split(",");
			  int hod = Integer.parseInt(hodAndTTArray[0]);
			  float meanTravelTime =  Float.parseFloat(hodAndTTArray[1]);
			  hoursArray[hod] = hoursArray[hod] + meanTravelTime;
			  count[hod] = count[hod] +1;
		  }
		  
		  //System.out.println(Arrays.toString(hoursArray));
		  
		  for(int i=0 ;i <24 ; i++){
			  if(hoursArray[i]!=0.0){
				  hoursArray[i] = hoursArray[i] / count[i];
			  }
		  }
		  
		  
		 // System.out.println(Arrays.toString(hoursArray));
		  calculateLowestHighestAndSD(hoursArray,count,context,key);
		 // System.exit(1);		  
	  //}
  }

private void calculateLowestHighestAndSD(float[] hoursArray, int[] count, Context context, Text key) throws IOException, InterruptedException {
	float highest = calculateHighest(hoursArray);
	float lowest = calculateLowest(hoursArray);
	float mean = calculateMean(hoursArray);
	float sd = calculateStandardDeviation(hoursArray, mean);
	//System.out.println(lowest);
	RoutesInfo rf = new RoutesInfo();
	rf.setHighestTravelTime(highest);
	rf.setLowestTravelTime(lowest);
	rf.setMeanTravelTime(mean);
	rf.setStandardDeviation(sd);
	context.write(key,rf);
	
}

private float calculateStandardDeviation(float[] hoursArray, float mean) {
	float sd = 0;
	for (int i=0; i<hoursArray.length;i++)
	{
	    sd = (float) (sd + Math.pow(hoursArray[i] - mean, 2));
	}
	
	float standardDeviation = (float) Math.sqrt(sd/hoursArray.length);
	
	return standardDeviation;
}

private float calculateMean(float[] hoursArray) {
	float sum = 0;
	for(int i=0; i<hoursArray.length; i++)
    {
		sum = sum + hoursArray[i];
    }
	
	float average = sum / hoursArray.length;
	return average;
}

private float calculateLowest(float[] inputArray) {
	 float minValue = Float.MAX_VALUE;
	    for(int i=1;i<inputArray.length;i++){ 
	      if( inputArray[i]!=0.0 && inputArray[i] < minValue){ 
	        minValue = inputArray[i]; 
	      } 
	    } 
	    return minValue; 
}

private float calculateHighest(float[] hoursArray) {
	float maxValue = hoursArray[0]; 
    for(int i=1;i < hoursArray.length;i++){ 
      if(hoursArray[i] > maxValue){ 
         maxValue = hoursArray[i]; 
      } 
    } 
    return maxValue; 
}

}