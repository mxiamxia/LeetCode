package com.min.leetcode;

public class _239SlidingWindowMaximum {
	
	/*
	 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

		For example,
		Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
		
		Window position                Max
		---------------               -----
		[1  3  -1] -3  5  3  6  7       3
		 1 [3  -1  -3] 5  3  6  7       3
		 1  3 [-1  -3  5] 3  6  7       5
		 1  3  -1 [-3  5  3] 6  7       5
		 1  3  -1  -3 [5  3  6] 7       6
		 1  3  -1  -3  5 [3  6  7]      7
		Therefore, return the max sliding window as [3,3,5,5,6,7].
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		maxSlidingWindow(new int[]{9, 11}, 2);
	}
	public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 1) {
            return new int[]{};
        }
        int len = nums.length;
        int[] res = new int[len-k+1];
        for (int i=k-1; i<len; i++) {
        	int max = Integer.MIN_VALUE;
            for(int j=i; j>i-k; j--) {
                max = Math.max(nums[j], max);
                res[i-k+1] = max;
            }
        }
        return res;
    }

}
