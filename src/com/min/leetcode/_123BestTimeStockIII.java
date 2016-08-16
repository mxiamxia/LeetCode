package com.min.leetcode;

public class _123BestTimeStockIII {

	/*
	 * Say you have an array for which the ith element is the price of a given
	 * stock on day i.
	 * 
	 * Design an algorithm to find the maximum profit. You may complete at most
	 * two transactions.
	 * 
	 * Note: You may not engage in multiple transactions at the same time (ie,
	 * you must sell the stock before you buy again).
	 * 
	 * 题解：
	 * 
	 * 根据题目要求，最多进行两次买卖股票，而且手中不能有2只股票，就是不能连续两次买入操作。
	 * 
	 * 所以，两次交易必须是分布在2各区间内，也就是动作为：买入卖出，买入卖出。
	 * 
	 * 进而，我们可以划分为2个区间[0,i]和[i,len-1]，i可以取0~len-1。
	 * 
	 * 那么两次买卖的最大利润为：在两个区间的最大利益和的最大利润。
	 * 
	 * 一次划分的最大利益为：Profit[i] = MaxProfit(区间[0,i]) + MaxProfit(区间[i,len-1]);
	 * 
	 * 最终的最大利润为：MaxProfit(Profit[0], Profit[1], Profit[2], ... , Profit[len-1])。
	 */


	public static void main(String[] args) {
		// int[] prices = {3,3,5,0,0,3,1,4};
		int[] prices = { 2, 1, 2, 0, 1 };
		System.out.println(maxProfit(prices));
	}

	// 基本思想是分成两个时间段，然后对于某一天，计算之前的最大值和之后的最大值
	public static int maxProfit(int[] prices) {
		if (prices.length == 0) {
			return 0;
		}

		int max = 0;
		// dp数组保存左边和右边的利润最大值
		int[] left = new int[prices.length]; // 计算[0,i]区间的最大值
		int[] right = new int[prices.length]; // 计算[i,len-1]区间的最大值

		process(prices, left, right);

		// O(n)找到最大值
		for (int i = 0; i < prices.length; i++) {
			max = Math.max(max, left[i] + right[i]);
		}

		return max;
	}

	public static void process(int[] prices, int[] left, int[] right) {
		left[0] = 0;
		int min = prices[0]; // 最低买入价

		// 左边递推公式
		for (int i = 1; i < left.length; i++) {
			left[i] = Math.max(left[i - 1], prices[i] - min); // i的最大利润为（i-1的利润）和（当前卖出价和之前买入价之差）的较大那个
			min = Math.min(min, prices[i]); // 更新最小买入价
		}

		right[right.length - 1] = 0;
		int max = prices[right.length - 1]; // 最高卖出价
		// 右边递推公式
		for (int i = right.length - 2; i >= 0; i--) {
			right[i] = Math.max(right[i + 1], max - prices[i]); // i的最大利润为（i+1的利润）和（最高卖出价和当前买入价之差）的较大那个
			max = Math.max(max, prices[i]); // 更新最高卖出价
		}

		// System.out.println(Arrays.toString(left));
		// System.out.println(Arrays.toString(right));
	}

}
