package com.min.leetcode;

public class _189RotateArray {

	/*
	 * Rotate an array of n elements to the right by k steps.
	 * 
	 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated
	 * to [5,6,7,1,2,3,4].
	 * 
	 * Solution,
	 * rotate the last k elements to front.
	 * 1, reverse first length-k elements (start from 0, so code should be (0, len-k-1)
	 * 2, reverse the last k elements
	 * 3, reverse whole array
	 * 
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		rotate(new int[] { 1, 2, 3, 4, 5, 6 }, 2);
	}

	public static void rotate(int[] nums, int k) {
		int len = nums.length;
		k = k % len;
		if (k == 0) {
			return;
		}
		reverse(nums, 0, len - k - 1);
		reverse(nums, len - k, len - 1);
		reverse(nums, 0, len - 1);
	}

	private static void reverse(int[] nums, int start, int end) {
		if (nums == null || nums.length <= 1) {
			return;
		}
		while (start < end) {
			swap(nums, start, end);
			start++;
			end--;
		}
	}

	private static void swap(int[] nums, int start, int end) {
		int tmp = nums[start];
		nums[start] = nums[end];
		nums[end] = tmp;
	}

}
