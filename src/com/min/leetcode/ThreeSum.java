import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ThreeSum {

	/** 
	 * @author Min
	 * @date May 13, 2015
	 * @return void 
	 * @throws 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {-2,0,1,1,2};
		threeSum(input);
	}
	 public static List<List<Integer>> threeSum(int[] nums) {
	        List<List<Integer>> result = new  ArrayList<List<Integer>>();
	        if(nums.length<3)
	        {
	            return result;
	        }
	        Arrays.sort(nums);
	        for(int i=0;i<nums.length-2;i++)
	        {
	        	//Avoid duplicated calculation if neighbors are the same
	            if(i==0 || nums[i]>nums[i-1])
	            {
	                int neg = -nums[i];
	                int start = i+1;
	                int end = nums.length-1;
	                while(start<end)
	                {
	                    if((nums[start]+nums[end])==neg)
	                    {
	                        List<Integer> each = new ArrayList<Integer>();
	                        each.add(nums[i]);
	                        each.add(nums[start]);
	                        each.add(nums[end]);
	                        start++;
						    end--;
						    //avoid duplicate solution
	                        if(!result.contains(each))
	                        {
	                        	result.add(each);
	                        }
	                    }
	                    //if 
	                    else if(nums[start]+nums[end]<neg)
	                    {
	                    	start++;
	                    }
	                    else
	                    {
	                    	end--;
	                    }
	                }
	            }
	        }
	        return result;
	    }
}
