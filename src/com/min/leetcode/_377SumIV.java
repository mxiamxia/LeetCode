package com.min.leetcode;

public class _377SumIV {
	
	
	/**
			nums = [1, 2, 3]
			target = 4

			The possible combination ways are:
			(1, 1, 1, 1)
			(1, 1, 2)
			(1, 2, 1)
			(1, 3)
			(2, 1, 1)
			(2, 2)
			(3, 1)

			Note that different sequences are counted as different combinations.

			Therefore the output is 7.
	*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1, 2, 3};
		int target = 4;
		System.out.println(combinationSum4(nums, target));
	}

	public static int combinationSum4(int[] nums, int target) {
		int[] dp = new int[target+1];
        dp[0] = 1;
        for(int i=1; i<=target; i++) {
            for(int num : nums) {
            	if (i >= num) {
            		dp[i] += dp[i-num];
            	}
            }
        }
        return dp[target];
	}
}
