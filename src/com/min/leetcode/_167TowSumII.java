package com.min.leetcode;

public class _167TowSumII {

	/*
	 * Two Sum II - Input array is sorted Total Accepted: 441 Total Submissions:
	 * 1017 Given an array of integers that is already sorted in ascending
	 * order, find two numbers such that they add up to a specific target
	 * number. The function twoSum should return indices of the two numbers such
	 * that they add up to the target, where index1 must be less than index2.
	 * Please note that your returned answers (both index1 and index2) are not
	 * zero-based. You may assume that each input would have exactly one
	 * solution. Input: numbers={2, 7, 11, 15}, target=9 Output: index1=1,
	 * index2=2
	 */

	public int[] twoSum(int[] numbers, int target) {
		if (numbers.length < 2) {
			return null;
		}
		int i = 0, j = numbers.length-1;
		while (i < j) {
			if ( (numbers[i] + numbers[j]) < target ) {
				i++;
			} else if ((numbers[i] + numbers[j]) < target ) {
				j--;
			} else {
//				int[] res = {i+1, j+1};
//				return res;
				return new int[]{i+1, j+1};
			}
		}
		return null;
	}
}
