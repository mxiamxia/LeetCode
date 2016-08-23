package com.min.leetcode;

import java.util.SortedSet;
import java.util.TreeSet;

public class _220ContainDuplicatesIII {

	/*
	 * Given an array of integers, find out whether there are two distinct
	 * indices i and j in the array such that the difference between nums[i] and
	 * nums[j] is at most t and the difference between i and j is at most k.
	 */

	public static void main(String[] args) {
		containsNearbyAlmostDuplicate(new int[]{1, 2}, 2, 1);
	}
	public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if (nums == null || nums.length < 2 || k < 0 || t < 0)
			return false;

		TreeSet<Long> set = new TreeSet<Long>();
		for (int i = 0; i < nums.length; i++) {
			long curr = (long) nums[i];

			long leftBoundary = (long) curr - t;
			long rightBoundary = (long) curr + t + 1; 
			SortedSet<Long> sub = set.subSet(leftBoundary, rightBoundary);
			if (sub.size() > 0)
				return true;

			set.add(curr);

			if (i >= k) {
				set.remove((long) nums[i - k]);
			}
		}

		return false;
	}
}
