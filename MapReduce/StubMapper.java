import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class StubMapper extends Mapper<LongWritable, Text, Text, Text> {
	
	Text sourceAndDestinationID;
	Text hodAndTravelTime;
	
  public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
	  String line = value.toString();
	  String[] tokens = line.split(",");
	  String comma= ",";
	  
	  
	  if (key.get() == 0 && value.toString().contains("source") /*Some condition satisfying it is header*/)
          return;
	  
	  else{
		  
		  if(tokens.length == 7){
			  sourceAndDestinationID = new Text(tokens[0]);
			  sourceAndDestinationID.append((comma).getBytes(), 0, comma.length());
			  sourceAndDestinationID.append((tokens[1]).getBytes(), 0, tokens[1].length());
			  hodAndTravelTime = new Text(tokens[2]);
			  hodAndTravelTime.append((comma).getBytes(), 0, comma.length());
			  hodAndTravelTime.append((tokens[3]).getBytes(), 0, tokens[3].length());
			  context.write(sourceAndDestinationID, hodAndTravelTime);
			 
		  }
		
	  }
	  
  }
}
