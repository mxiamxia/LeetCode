package com.min.leetcode;

public class _209MinimumSizeSubarraySum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(minSubArrayLen(11, new int[]{1,2,3,4,5}));
	}
	
	public static int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        int sum = 0;
        int right = 0;
        int result = 0;
        while (right <= nums.length) {
            if (sum < s) {
                if (right == nums.length) {
                    break;
                }
                sum += nums[right];
                right++;
            } else {
                if (result == 0) {
                    result = right -left;
                }
                sum = sum - nums[left];
                result = Math.min(result, right-left);
                left++;
            }
        }
        return result;
    }

}
