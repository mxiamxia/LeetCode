package com.min.leetcode;

import java.util.Arrays;

public class _279PerfectSquares {

	/*
	 * Given a positive integer n, find the least number of perfect square
	 * numbers (for example, 1, 4, 9, 16, ...) which sum to n.
	 * 
	 * For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13,
	 * return 2 because 13 = 4 + 9.
	 * 
	 * 解法II：动态规划（Dynamic Programming）

		时间复杂度：O(n * sqrt n)
		
		初始化将dp数组置为无穷大；令dp[y * y] = 1，其中：y * y <= n
		
		状态转移方程：
		
		dp[x + y * y] = min(dp[x + y * y], dp[x] + 1)
		其中：dp [i] 表示凑成i所需的平方和数字的最小个数，并且 x + y * y <= n
		
		
		复杂度
			时间 O(N^2) 空间 O(N)
			
			思路
			如果一个数x可以表示为一个任意数a加上一个平方数bｘb，也就是x=a+bｘb，那么能组成这个数x最少的平方数个数，就是能组成a最少的平方数个数加上1（因为b*b已经是平方数了）。
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i=0; i*i<=n; i++) {
            dp[i*i] = 1;
        }
        for (int i=0; i<=n; i++) {
            for (int j=0; i+j*j<=n; j++) {
                dp[i+j*j] = Math.min(dp[i+j*j], dp[i]+1);
            }
        }
        return dp[n];
    }

}
