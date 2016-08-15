package com.min.leetcode;

public class _169MajorityElement {

	/*
	 * Given an array of size n, find the majority element. The majority element
	 * is the element that appears more than ⌊ n/2 ⌋ times.
	 * 
	 * You may assume that the array is non-empty and the majority element
	 * always exist in the array.
	 * 
	 * 思路：既然最多元素出现了n/2次，那我就想用抵消的思想，用它和与它不相等的元素一一相消，剩下的一定就是最多的那个元素。根据这个想法，有了如下代码。
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int majorityElement(int[] nums) {
		int counter = 0;
		int result = nums[0];
		for (int i = 0; i < nums.length; i++) {
			if (counter == 0 || result == nums[i]) {
				result = nums[i];
				counter++;
			} else {
				counter--;
			}
		}
		return result;
	}
}
