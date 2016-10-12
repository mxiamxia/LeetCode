package com.min.dp;

import static org.junit.Assert.*;

import org.junit.Test;

public class StockMaxProfit {

	/*
	 * 第二题是给了一个数组， 1, 2, 3, 4, 5, 6, 7, 8 
	 * 					 1, 4, 7, 9,12,14,15,20
	 * 第一排是index，也是一笔交易中卖出的股票数量，第二排是对应的收益，比如说我第一笔交易卖了三只股票，那么收益就是7。可以选择任意的卖法，
	 * 比如一只一只的卖，或者也可以一次性卖8只。题目要求求得最大收益。楼主用的recursive的解法，如果一共有8只股票，这一次卖了两只之后，
	 * 下一层的问题就是一共有6只，求最大收益。用一个global
	 * variable存最大收益，碰到大的就更新。小哥好像不是很明白我的解法（为什么不明白啊？！），和他解释了一通之后还是没有完全确信，
	 * 之后他就问了一下时间复杂度。面完之后和朋友讨论才知道还可以用dp做。
	 * 
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int maxProfit(int[] arr) {
		int[] dp = new int[arr.length + 1];
		for (int i=1; i<=arr.length; i++) {
			dp[i] = arr[i-1];
			for (int j=0; j<i; j++) {
				dp[i] = Math.max(dp[i], dp[i-j]+dp[j]);
			}
		}
		return dp[arr.length];
	}
	
	@Test
	public void test1() {
		int[] arr = new int[] {1, 4, 7, 9,12,14,15,17};
		int result = maxProfit(arr);
		assertEquals(21, result);
	}

}
