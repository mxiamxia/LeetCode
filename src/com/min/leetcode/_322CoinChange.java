package com.min.leetcode;

import java.util.Arrays;

public class _322CoinChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				_322CoinChange in = new _322CoinChange();
		in.coinChange(new int[]{2147483647}, 2);
	}

	 public int coinChange(int[] coins, int amount) {
	        if (coins == null || coins.length == 0 || amount < 0) {
	            return -1;
	        }
	        int[] dp = new int[amount+1];
	        Arrays.fill(dp, Integer.MAX_VALUE);
	        dp[0] = 0;
	        for (int i=0; i<=amount; i++) {
	            for (int j=0; j<coins.length; j++) {
	                if (i+coins[j] <=amount) {
	                    if (dp[i] == Integer.MAX_VALUE) {
	                        dp[i+coins[j]] = dp[i+coins[j]];
	                    } else {
	                        dp[i+coins[j]] = Math.min(dp[i+coins[j]], dp[i]+1);
	                    }
	                }
	            }
	        }
	        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount] ;
	    }
}
