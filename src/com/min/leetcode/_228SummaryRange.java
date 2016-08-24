package com.min.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _228SummaryRange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<String> summaryRanges(int[] nums) {
		List<String> res = new ArrayList<String>();
		if (nums == null || nums.length == 0) {
			return res;
		}
		int len = nums.length;
		if (len == 1) {
			res.add(String.valueOf(nums[0]));
			return res;
		}
		int prev = nums[0];
		for (int i = 1; i < len; i++) {
			if (nums[i] - nums[i - 1] != 1) {
				if (nums[i - 1] != prev) {
					res.add(prev + "->" + nums[i - 1]);
				} else {
					res.add(String.valueOf(nums[i - 1]));
				}
				prev = nums[i];
			}
			if (i == len - 1) {
				if (prev == nums[i]) {
					res.add(String.valueOf(nums[i]));
				} else {
					res.add(prev + "->" + nums[i]);
				}
			}
		}
		return res;
	}
}
