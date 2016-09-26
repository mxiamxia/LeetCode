package com.min.leetcode;

import java.util.Arrays;

public class _334IcreasingTripleSequence {

	/*
	 * Given an unsorted array return whether an increasing subsequence of
	 * length 3 exists or not in the array.
	 * 
	 * Formally the function should: Return true if there exists i, j, k such
	 * that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return
	 * false. Your algorithm should run in O(n) time complexity and O(1) space
	 * complexity.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * 但是题目中要求我们O(n)的时间复杂度和O(1)的空间复杂度，上面的那种方法一条都没满足，所以白写了。我们下面来看满足题意的方法，这个思路是，
	 * 我们遍历数组，维护一个最小值，和倒数第二小值，遍历原数组的时候，如果当前数字小于等于最小值，更新最小值，如果小于等于倒数第二小值，更新倒数第二小值
	 * ，如果当前数字比最小值和倒数第二小值都大，说明此时有三个递增的子序列了，直接返回ture，否则遍历结束返回false，参见代码如下：
	 */

	public boolean increasingTriplet(int[] nums) {
		int m1 = Integer.MAX_VALUE, m2 = Integer.MAX_VALUE;
		for (Integer a : nums) {
			if (m1 >= a)
				m1 = a;
			else if (m2 >= a)
				m2 = a;
			else
				return true;
		}
		return false;
	}

	// dp, O(n) O(n)

	/*
	 * 这道题让我们求一个无序数组中是否有任意三个数字是递增关系的，我最先相处的方法是用一个dp数组，dp[i]表示在i位置之前小于等于nums[i]
	 * 的数字的个数(包括其本身)，我们初始化dp数组都为1，然后我们开始遍历原数组，对当前数字nums[i]，我们遍历其之前的所有数字，
	 * 如果之前某个数字nums[j]小于nums[i]，那么我们更新dp[i] = max(dp[i], dp[j] +
	 * 1)，如果此时dp[i]到3了，则返回true，若遍历完成，则返回false，参见代码如下：
	 */
	public boolean increasingTripletDp(int[] nums) {
		int[] dp = new int[nums.length];
		Arrays.fill(dp, 1);
		for (int i = 1; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
					if (dp[i] > 2) {
						return true;
					}
				}
			}
		}
		return false;
	}
}
