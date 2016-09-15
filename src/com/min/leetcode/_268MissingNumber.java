package com.min.leetcode;

public class _268MissingNumber {
	/*
	 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n,
	 * find the one that is missing from the array.
	 * 
	 * For example, Given nums = [0, 1, 3] return 2.
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int missingNumber(int[] nums) {
        int sum = 0, n = nums.length;
        for (int a : nums) {
            sum += a;
        }
        return n * (n + 1) / 2 - sum;
    }

}
