public class FirstPositive {

	/**
	 * @author Min
	 * @date Jun 9, 2015
	 * @return void
	 * @throws
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new FirstPositive().test();

	}

	private void test() {
		// TODO Auto-generated method stub
		int[] input = { 3, 4, -1, 1 };
		firstMissingPositive1(input);
	}

	public int firstMissingPositive(int[] nums) {
		int ret = 1;
		if (nums == null || nums.length == 0) {
			return ret;
		}
		int len = nums.length;
		for (int i = 0; i < len; i++) {
			if (nums[i] <= len && nums[i] > 0 && nums[i] != (i + 1)
					&& nums[nums[i] - 1] != nums[i]) {
				swap(nums, i);
			}
		}

		for (int j = 0; j < len; j++) {
			if (nums[j] != j + 1) {
				return j + 1;
			}
		}
		return len + 1;
	}

	public void swap(int[] nums, int i) {
		int temp = nums[nums[i] - 1];
		nums[nums[i] - 1] = nums[i];
		nums[i] = temp;
	}
	
	public int firstMissingPositive1(int[] A) {
        int i = 0;
        while (i < A.length) {
            if (A[i] != i + 1 && A[i] >= 1 && A[i] <= A.length && A[A[i] - 1] != A[i]) {
                int tmp = A[A[i] - 1];
                A[A[i] - 1] = A[i];
                A[i] = tmp;
            } else
                i++;
        }
        for (i = 0; i < A.length; i++) {
            if (A[i] != i + 1)
                return i + 1;
        }
        return A.length + 1;
    }
}
