package com.min.leetcode;

public class _209MinimumSizeSubarraySum {

	/*
	 * 
	 * Given an array of n positive integers and a positive integer s, find the
	 * minimal length of a subarray of which the sum ≥ s. If there isn't one,
	 * return 0 instead.
	 * 
	 * For example, given the array [2,3,1,2,4,3] and s = 7, the subarray [4,3]
	 * has the minimal length of 2 under the problem constraint.
	 * 
	 * Analysis
	 * 
	 * We can use 2 points to mark the left and right boundaries of the sliding
	 * window. When the sum is greater than the target, shift the left pointer;
	 * when the sum is less than the target, shift the right pointer.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(minSubArrayLen(11, new int[] { 1, 2, 3, 4, 5 }));
	}

	public static int minSubArrayLen(int s, int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int left = 0;
		int sum = 0;
		int right = 0;
		int result = 0;
		while (right <= nums.length) {
			if (sum < s) {
				if (right == nums.length) {
					break;
				}
				sum += nums[right];
				right++;
			} else {
				if (result == 0) {
					result = right - left;
				}
				sum = sum - nums[left];
				result = Math.min(result, right - left);
				left++;
			}
		}
		return result;
	}

}
