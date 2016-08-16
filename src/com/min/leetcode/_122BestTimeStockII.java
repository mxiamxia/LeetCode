package com.min.leetcode;

public class _122BestTimeStockII {

	/*
	 * Say you have an array for which the ith element is the price of a given
	 * stock on day i.
	 * 
	 * Design an algorithm to find the maximum profit. You may complete as many
	 * transactions as you like (ie, buy one and sell one share of the stock
	 * multiple times). However, you may not engage in multiple transactions at
	 * the same time (ie, you must sell the stock before you buy again).
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxProfit(int[] prices) {
		int len = prices.length;
		if (len <= 1) {
			return 0;
		}
		int i = 0;
		int total = 0;
		while (i < len - 1) {
			int buy, sell;
			while (i + 1 < len && prices[i] > prices[i + 1]) {
				i++;
			}
			buy = i;
			i++;
			while (i < len && prices[i] >= prices[i - 1]) {
				i++;
			}
			sell = i - 1;
			total += prices[sell] - prices[buy];
		}
		return total;
	}
}
