package com.min.leetcode;

public class _213HouseRobII {
	public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(robMe(nums, 0, nums.length-1), robMe(nums, 1, nums.length));        
    }
    private int robMe(int[] nums, int start, int end) {
        if (end - start <= 2) return nums[start];
        int[] dp = new int[end];
        dp[start] = nums[start];
        dp[start+1] = Math.max(nums[start], nums[start+1]);
        for (int i=start+2; i<end; i++) {
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        }
        return dp[end-1];
    }
    public static void main(String[] args) {
    	rob(new int[]{1, 1, 1, 1});
    }

}
