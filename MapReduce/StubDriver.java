import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

public class StubDriver {

  public static void main(String[] args) throws Exception {

    /*
     * Validate that two arguments were passed from the command line.
     */
//    if (args.length != 2) {
//      System.out.printf("Usage: StubDriver <input dir> <output dir>\n");
//      System.exit(-1);
//    }

    /*
     * Instantiate a Job object for your job's configuration. 
     */
    Configuration conf = new Configuration();
    
    conf.set("mapred.textoutputformat.separator", ",");
    
    Job job = new Job(conf);
   
    /*
     * Specify the jar file that contains your driver, mapper, and reducer.
     * Hadoop will transfer this jar file to nodes in your cluster running 
     * mapper and reducer tasks.
     */
    job.setJarByClass(StubDriver.class);
    job.setMapperClass(StubMapper.class);
    job.setReducerClass(StubReducer.class);
    job.setMapOutputKeyClass(Text.class);
    job.setMapOutputValueClass(Text.class);
    job.setInputFormatClass(TextInputFormat.class);
    job.setOutputFormatClass(TextOutputFormat.class);
    
    /*
     * Specify an easily-decipherable name for the job.
     * This job name will appear in reports and logs.
     */
    job.setJobName("Stub Driver");
//    
//    FileSystem fs = FileSystem.getLocal(conf);
//    Path inputPath = fs.makeQualified(new Path(args[0]));  // local path
//    Path outputPath = fs.makeQualified(new Path(args[1]));  
    FileInputFormat.setInputPaths(job, new Path(args[0]));
    FileOutputFormat.setOutputPath(job, new Path(args[1]));

    /*
     * TODO implement
     */
    
    /*
     * Start the MapReduce job and wait for it to finish.
     * If it finishes successfully, return 0. If not, return 1.
     */
    boolean success = job.waitForCompletion(true);
    if(success){
    	 Configuration conf1 = new Configuration();
    	 conf1.set("mapred.textoutputformat.separator", ",");
    	 Job job1 = new Job(conf);
    	 job1.setOutputKeyClass(Text.class);
    	 job1.setOutputValueClass(RoutesInfo.class);
    	 job1.setJarByClass(StubDriver.class);
    	 job1.setMapperClass(TopTenRoutes.Map.class);
    	 job1.setReducerClass(TopTenRoutes.Reduce.class);
    	 job1.setInputFormatClass(TextInputFormat.class);
    	 job1.setOutputFormatClass(TextOutputFormat.class);
    	 job1.setJobName("Top Ten Routes");
    	 job1.setNumReduceTasks(1); 
//    	 FileSystem fs1 = FileSystem.getLocal(conf);
//    	 Path inputPath1 = fs1.makeQualified(new Path());  // local path
//    	 Path outputPath1 = fs1.makeQualified(new Path("/home/cloudera/Downloads/Output1"));  
    	 FileInputFormat.setInputPaths(job1, new Path(args[1]));
    	 FileOutputFormat.setOutputPath(job1, new Path(args[2]));
    	 job1.waitForCompletion(true);
    }
    System.exit(success ? 0 : 1);
  }
}

