public class SearchInsert {

	/**
	 * @author Min
	 * @date Jun 3, 2015
	 * @return void
	 * @throws
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new SearchInsert().test());

	}

	private int test() {
		// TODO Auto-generated method stub
		int[] input = {1};
		int target = 0;
		return searchInsert(input, target);
	}

	public int searchInsert(int[] nums, int target) {
		int ret = -1;
		if (nums.length == 0) {
			return ret;
		}
		int start = 0;
		int end = nums.length - 1;
		if (nums.length == 1) {
			if (target > nums[0]) {
				return 0;
			} else {
				return 1;
			}
		}
		while (start <= end) {
			int mid = (start + end) / 2;
			if (mid > start && nums[mid - 1] > target && nums[mid] < target)
				return mid;
			if (target < nums[mid]) {
				end = mid - 1;
			} else if (target > nums[mid]) {
				start = mid + 1;
			} else {
				return mid;
			}
		}

		return ret;
	}
}
