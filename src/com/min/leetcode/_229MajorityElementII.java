package com.min.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _229MajorityElementII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		majorityElement(new int[]{2,2,9,3,9,3,9,3,9,3,9,3,9,3,9,3,9});
	}

	public static List<Integer> majorityElement(int[] nums) {
		List<Integer> res = new ArrayList<Integer>();
		if (nums == null || nums.length == 0) {
			return res;
		}
		int len = nums.length;
		if (len == 1) {
			res.add(nums[0]);
			return res;
		}
		int n1 = 0;
		int n2 = 0;
		int c1 = 0;
		int c2 = 0;
		for (int i = 0; i < len; i++) {
			if (n1 == nums[i]) {
				c1++;
			} else if (n2 == nums[i]) {
				c2++;
			} else if (c1 == 0) {
				n1 = nums[i];
				c1++;
			} else if (c2 == 0) {
				n2 = nums[i];
				c2++;
			} else {
				c1--;
				c2--;
			}
		}
		c1 = 0;
		c2 = 0;
		for (int i = 0; i < len; i++) {
			if (nums[i] == n1) {
				c1++;
			}
			if (nums[i] == n2) {
				c2++;
			}
		}
		if (c1 > len / 3) {
			res.add(n1);
		}
		if (c2 > len / 3 && n1 != n2) {
			res.add(n2);
		}
		return res;
	}

}
