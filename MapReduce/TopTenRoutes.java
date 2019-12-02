import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;

public class TopTenRoutes {
	
	public static class Map extends Mapper<LongWritable, Text, Text, RoutesInfo >{
		String comma= ",";
		private RoutesInfo rf = new RoutesInfo();
		private TreeSet<RoutesInfo> top10Routes = new TreeSet<RoutesInfo>();
		
		public RoutesInfo transformStringToRoutesInfo(String details){
			RoutesInfo output = new RoutesInfo();
			String[] tokens = details.split(",");
			
			Text sourceAndDestinationID = new Text(tokens[0]);
			sourceAndDestinationID.append((comma).getBytes(), 0, comma.length());
			sourceAndDestinationID.append((tokens[1]).getBytes(), 0, tokens[1].length());
			output.setSourceAndDestinationID(sourceAndDestinationID.toString());
			output.setHighestTravelTime(Float.parseFloat(tokens[2]));
			output.setLowestTravelTime(Float.parseFloat(tokens[3]));
			output.setMeanTravelTime(Float.parseFloat(tokens[4]));
			output.setStandardDeviation(Float.parseFloat(tokens[5]));
			
			return output;
			
		}
		
		public void map (LongWritable key, Text value, Context context) throws IOException, InterruptedException{
			String line = value.toString();
			rf = transformStringToRoutesInfo(line);
			top10Routes.add(rf);
			if(top10Routes.size()>10){
				top10Routes.remove(top10Routes.first());
			}
		}
			
		protected void cleanup(Context context) throws IOException, InterruptedException {
			
			for(RoutesInfo i: top10Routes){
				context.write(new Text(i.getSourceAndDestinationID()),i);
			}
			
		}
		
	}
	
	public static class Reduce extends Reducer <Text, RoutesInfo, Text, RoutesInfo>{
		
		TreeSet<RoutesInfo> top10 = new TreeSet<RoutesInfo>();
		String comma= ",";
		
		public RoutesInfo trasnformStringToRoutesInfo(Text key, String details){
			
			RoutesInfo output = new RoutesInfo();
			String[] tokens = details.split(",");
			String sourceIDAndDestinationID = key.toString();
			
//			Text sourceAndDestinationID = new Text(tokens[0]);
//			sourceAndDestinationID.append((comma).getBytes(), 0, comma.length());
//			sourceAndDestinationID.append((tokens[1]).getBytes(), 0, tokens[1].length());
			output.setSourceAndDestinationID(sourceIDAndDestinationID);
			output.setHighestTravelTime(Float.parseFloat(tokens[0]));
			output.setLowestTravelTime(Float.parseFloat(tokens[1]));
			output.setMeanTravelTime(Float.parseFloat(tokens[2]));
			output.setStandardDeviation(Float.parseFloat(tokens[3]));
			
			return output;
			
		}
		
		public void reduce(Text key, Iterable<RoutesInfo> values, Context context) throws IOException, InterruptedException{
			
			Iterator<RoutesInfo> itrr = values.iterator();
			
			while(itrr.hasNext()){
				RoutesInfo itr = itrr.next(); 
				Text temp = new Text(itr.toString());
				RoutesInfo temp1 = trasnformStringToRoutesInfo(key, temp.toString());
						
				top10.add(temp1);
				if(top10.size() > 10) {
					top10.remove(top10.last());
				}
			}
			}
		
		protected void cleanup(Context context) throws IOException, InterruptedException {
			/*
			 * Write the output in descending order
			 */

			for(RoutesInfo i : top10.descendingSet()) {
				context.write(new Text(i.getSourceAndDestinationID()), i);
			}
		}
			
		}
		
	}
