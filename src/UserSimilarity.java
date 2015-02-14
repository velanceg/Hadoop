
import java.util.*;
import java.lang.*;

/**
*
* @author velan and soorya
*/

public class UserSimilarity {
	
	public double getSimilarity(int[] count1,int[] count2){
		double result = 0;
		double sum_sq_x = 0;
		double sum_sq_y = 0;
		double sum_coproduct = 0;
		double mean_x = (double)count1[0];
		double mean_y = (double)count2[0];
		for(int i=2;i<count1.length+1;i+=1){
			double sweep =Double.valueOf(i-1)/i;
			double delta_x = (double)count1[i-1]-mean_x;
			double delta_y = (double)count2[i-1]-mean_y;
			sum_sq_x += delta_x * delta_x * sweep;
			sum_sq_y += delta_y * delta_y * sweep;
			sum_coproduct += delta_x * delta_y * sweep;
			mean_x += delta_x / i;
			mean_y += delta_y / i;
		}
		double pop_sd_x = (double) Math.sqrt(sum_sq_x/count1.length);
		double pop_sd_y = (double) Math.sqrt(sum_sq_y/count1.length);
		double cov_x_y = sum_coproduct / count1.length;
		result = cov_x_y / (pop_sd_x*pop_sd_y);
		return result;
	}

}

