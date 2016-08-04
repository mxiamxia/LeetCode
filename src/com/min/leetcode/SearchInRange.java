
public class SearchInRange {

	/** 
	 * @author Min
	 * @date Jun 3, 2015
	 * @return void 
	 * @throws 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new SearchInRange().test());
		
	}
	
	private int[] test() {
		// TODO Auto-generated method stub
		int[] input = {5, 7, 7, 8, 8, 10};
		int target = 8;
		return searchRange(input, target);
	}

	public int[] searchRange(int[] nums, int target) {
        int[] arr= new int[2];
        arr[0]=-1;
        arr[1]=-1;
        int cur = -1;
        if(nums.length == 0)
        {
            return arr;
        }
        
        int low = 0;
        int high = nums.length - 1;
        while(low<=high)
        {
            int mid = (low+high)/2;
            if(target < nums[mid])
            {
                high = mid -1;
            }
            else if(target > nums[mid])
            {
                low = mid + 1;
            }
            else
            {
                cur = mid;
                break;
            }
        }
        int left = cur;
        arr[0] = cur;
        while(left > 0)
        {
            left--;
            if(nums[left] == target)
            {
                arr[0] = left;
            }
            else
            {
                break;
            }
        }
        int right = cur;
        arr[1] = cur;
        while(right < nums.length-1)
        {
            right++;
            if(nums[right] == target)
            {
                arr[1] = right;
            }
            else
            {
                break;
            }
        }
        return arr;
    }

}
