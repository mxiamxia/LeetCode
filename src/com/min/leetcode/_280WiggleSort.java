package com.min.leetcode;

import java.util.Arrays;

public class _280WiggleSort {

	/*
	 * Given an unsorted array nums, reorder it in-place such that nums[0] <=
	 * nums[1] >= nums[2] <= nums[3]....
	 * 
	 * For example, given nums = [3, 5, 2, 1, 6, 4], one possible answer is [1,
	 * 6, 2, 5, 3, 4].
	 * 
	 * 复杂度 时间 O(NlogN) 空间 O(1)
	 * 
	 * 思路
	 * 根据题目的定义，摇摆排序的方法将会很多种。我们可以先将数组排序，这时候从第3个元素开始，将第3个元素和第2个元素交换。然后再从第5个元素开始，
	 * 将第5个元素和第4个元素交换，以此类推。就能满足题目要求。
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void wiggleSort(int[] nums) {
		if (nums == null || nums.length == 0) {
			return;
		}
		Arrays.sort(nums);
		for (int i=2; i<nums.length; i+=2) {
			int tmp = nums[i];
			nums[i] = nums[i-1];
			nums[i-1] = tmp;
		}
		return;
	}
}
