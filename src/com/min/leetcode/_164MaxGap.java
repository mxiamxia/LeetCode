package com.min.leetcode;

import java.util.Arrays;

public class _164MaxGap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maximumGap_1(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int result = 0;
        for(int i=1; i<nums.length; i++) {
            result = Math.max(result, nums[i] - nums[i-1]);
        }
        return result;
    }
}
