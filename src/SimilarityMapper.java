
/**
 *
 * @author velan and soorya
 */

import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;


public class SimilarityMapper extends MapReduceBase
implements Mapper<LongWritable, Text, Text, DoubleWritable> {
	
	private UserSong us=new UserSong();
	private UserSimilarity s=new UserSimilarity();
	private static int[] classcount1=new int[5];
	private static int[] classcount2=new int[5];
	private double result;
	
	
	public void map(LongWritable key, Text value,
			OutputCollector<Text,DoubleWritable> output, Reporter reporter)
			throws IOException {
		
		classcount1[0]=(int) us.getClassCountA("CAKCLXJ1332EB06A11");
		classcount1[1]=(int) us.getClassCountB("CAKCLXJ1332EB06A11");
		classcount1[2]=(int) us.getClassCountC("CAKCLXJ1332EB06A11");
		classcount1[3]=(int) us.getClassCountD("CAKCLXJ1332EB06A11");
		classcount1[4]=(int) us.getClassCountE("CAKCLXJ1332EB06A11");
		String[] words = value.toString().split(",");
		String userid2=words[0];
		if(userid2.equals("CAKCLXJ1332EB06A11")==false) {
			
			classcount2[0]=(int) us.getClassCountA(userid2);
			classcount2[1]=(int) us.getClassCountB(userid2);
			classcount2[2]=(int) us.getClassCountC(userid2);
			classcount2[3]=(int) us.getClassCountD(userid2);
			classcount2[4]=(int) us.getClassCountE(userid2);
			result = s.getSimilarity(classcount1,classcount2);
			output.collect(new Text(userid2), new DoubleWritable(result));
		}
	}

}
