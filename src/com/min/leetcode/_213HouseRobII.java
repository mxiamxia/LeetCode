package com.min.leetcode;

import java.util.PriorityQueue;

/*
 * After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not get too much attention. This time, all houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, the security system for these houses remain the same as for those in the previous street.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 */

public class _213HouseRobII {
	public static int rob(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return nums[0];
		}
		return Math.max(robMe(nums, 0, nums.length - 1), robMe(nums, 1, nums.length));
	}

	private int robMe(int[] nums, int start, int end) {
		if (end - start <= 2)
			return nums[start];
		int[] dp = new int[end];
		dp[start] = nums[start];
		dp[start + 1] = Math.max(nums[start], nums[start + 1]);
		for (int i = start + 2; i < end; i++) {
			dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
		}
		return dp[end - 1];
	}

	public static void main(String[] args) {
		rob(new int[] { 1, 1, 1, 1 });
		// PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		// q.offer(2);
		// q.offer(9);
		// q.offer(4);
		// System.out.println(q.peek());
	}

}
