
public class SearchRotateArray {

	/** 
	 * @author Min
	 * @date Jun 3, 2015
	 * @return void 
	 * @throws 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new SearchRotateArray().test());
	}
	
	public int test()
	{
		int[] input = {3,5,1};
		int target = 1;
		return search(input, target);
	}
	
	 public int search(int[] nums, int target) {
	        if(nums.length == 0)
	        {
	            return -1;
	        }
	        int low = 0;
	        int high = nums.length - 1;
	        
	        while(low <= high)
	        {
	            int mid = (low + high)/2;
	            if(target < nums[mid])
	            {
	                if(nums[mid] < nums[high]) //if target < mid, and left side is sorted, targt in left side
	                {
	                    high = mid -1;
	                }
	                else  
	                {
	                    if(target < nums[low])
	                    {
	                        low = mid +1;
	                    }
	                    else
	                    {
	                        high = mid -1;
	                    }
	                }
	            }
	            else if(target > nums[mid])
	            {
	                if(nums[low] < nums[mid])
	                {
	                    low = mid + 1;
	                }
	                else
	                {
	                    if(target > nums[high])
	                    {
	                        high = mid -1;
	                    }
	                    else
	                    {
	                        low = mid + 1;
	                    }
	                }
	            }
	            else
	                return mid;
	        }
	        return -1;
	    }

}
