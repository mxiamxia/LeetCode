import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class FourSum {

	/** 
	 * @author Min
	 * @date May 19, 2015
	 * @return void 
	 * @throws 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {-1,0,-5,-2,-2,-4,0,1,-2};
		fourSum(input,-9);
	}
	
	public static List<List<Integer>> fourSum(int[] nums, int target)
	{
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		
		if(nums.length<4 || nums==null)
		{
			return ret;
		}
		
		Arrays.sort(nums);
		for(int i=0; i<nums.length-1;i++)
		{
			for(int j=i+1; j<nums.length;j++)
			{
				int start = j+1;
				int end = nums.length-1;
				while(start<end)
				{
					int diff = target - (nums[i] + nums[j] + nums[start] + nums[end]);
					if(diff == 0)
					{
						List<Integer> tmp = new ArrayList<Integer>();
						tmp.add(nums[i]);
						tmp.add(nums[j]);
						tmp.add(nums[start]);
						tmp.add(nums[end]);
						while(!ret.contains(tmp))
						{
							ret.add(tmp);
						}
						do
						{
							start++;
						}while(start<end&&nums[start]==nums[start+1]);

						do
						{
							end--;
						}while(start<end&&nums[end] == nums[end-1]);
					}

					if(diff>0)
					{
						start++;
					}

					if(diff<0)
					{
						end--;
					}
				}
			}
		}
		
		return ret;
	}

}
