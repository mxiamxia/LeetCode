package com.min.leetcode;

import java.util.Arrays;

public class _259ThreeSumSmall {
	/*
	 * Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.

		For example, given nums = [-2, 0, 1, 3], and target = 2.
		
		Return 2. Because there are two triplets which sums are less than 2:
		
		[-2, 0, 1]
		[-2, 0, 3]
		Follow up: Could you solve it in O(n2) runtime?
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int threeSumSmaller(int[] nums, int target) {
		int count = 0;
		if (nums == null || nums.length == 0) {
			return count;
		}
		Arrays.sort(nums);
		if (nums[0] >= target) {
			return count;
		}
		
		for (int i=0; i<nums.length-2; i++) {
			int left = i+1;
			int right = nums.length - 1;
			while (left < right) {
				int sum = nums[i] + nums[left] + nums[right];
				if (sum < target) {
					count += right -left;
					left++;
				} else {
					right--;
				}
			}
		}
		return count;
	}
}
