


import java.io.IOException;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;

public class TestDriver {
	
	public static void main(String[] args) throws IOException {
	
	     
		JobConf conf = new JobConf(TestDriver.class);
		conf.setJobName("Song-Classifier");
		FileInputFormat.addInputPath(conf, new Path(args[0]));
		FileOutputFormat.setOutputPath(conf, new Path(args[1]));
		conf.setMapperClass(TestMapper.class);
		conf.setReducerClass(TestReducer.class);
		conf.setOutputKeyClass(Text.class);
		conf.setOutputValueClass(Text.class);
		conf.setJarByClass(TestDriver.class);
        JobClient.runJob(conf);
        
        JobConf conf1 = new JobConf(TestDriver.class);
		conf1.setJobName("User-Song-DataModifier");
		FileInputFormat.addInputPath(conf1, new Path(args[2]));
		FileOutputFormat.setOutputPath(conf1, new Path(args[3]));
		conf1.setMapperClass(UserSongMapper.class);
		conf1.setReducerClass(UserSongReducer.class);
		conf1.setOutputKeyClass(Text.class);
		conf1.setOutputValueClass(Text.class);
        conf1.setJarByClass(TestDriver.class);
		JobClient.runJob(conf1);
		
		JobConf conf2 = new JobConf(TestDriver.class);
		conf2.setJobName("User-Similarity");
		FileInputFormat.addInputPath(conf2, new Path(args[4]));
		FileOutputFormat.setOutputPath(conf2, new Path(args[5]));
		conf2.setMapperClass(SimilarityMapper.class);
		conf2.setReducerClass(SimilarityReducer.class);
		conf2.setOutputKeyClass(Text.class);
		conf2.setOutputValueClass(Text.class);
        conf2.setJarByClass(TestDriver.class);
		JobClient.runJob(conf2);
	
	}
}