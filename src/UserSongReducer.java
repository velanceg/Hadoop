/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author velan
 */

import java.io.IOException;
import java.util.Iterator;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

public class UserSongReducer extends MapReduceBase implements Reducer<Text,Text,Text,IntWritable>{
   
        
        private IdClassSong Is = new IdClassSong(); 
        private UserSong us=new UserSong();
        private int[] countClass=new int[5];
        private String cid;
        
        public String convertIntString(int[] num){
        	
        	String result;
        	int i;
        	result="";
        	for(i=0;i<5;i++){
        		
        		result=result+num[i]+",";
        	}
        	return result;
        	
        }
        
	public void reduce(Text key, Iterator<Text> values,
			OutputCollector<Text, IntWritable> output, Reporter reporter)
			throws IOException {
            
		
            countClass[0]=countClass[1]=countClass[2]=countClass[3]=countClass[4]=0;
        
            
            while(values.hasNext())
            {
            
            	cid = Is.getKeyValue(values.next().toString());
                
                
                if(cid.equals("A")){
                    countClass[0]++;
                }
                else if(cid.equals("B")){
                    countClass[1]++;
                }
                else if(cid.equals("C")){
                    countClass[2]++;
                }
                else if(cid.equals("D")){
                    countClass[3]++;
                }
                else if(cid.equals("E")){
                    countClass[4]++;
                }
                else {
                    ;
                }
                               
                
            }
            
            us.putClassCountA(key.toString(),countClass[0]);
            us.putClassCountB(key.toString(),countClass[1]);
            us.putClassCountC(key.toString(),countClass[2]);
            us.putClassCountD(key.toString(),countClass[3]);
            us.putClassCountE(key.toString(),countClass[4]); 
            
            output.collect(key, new IntWritable(us.getClassCountA(key.toString())));
            
        }
}
