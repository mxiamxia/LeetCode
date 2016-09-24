package com.min.leetcode;

public class _309BestTimetoBuyandSellStockwithCooldown {

	/*
	 * Say you have an array for which the ith element is the price of a given
	 * stock on day i.
	 * 
	 * Design an algorithm to find the maximum profit. You may complete as many
	 * transactions as you like (ie, buy one and sell one share of the stock
	 * multiple times) with the following restrictions:
	 * 
	 * You may not engage in multiple transactions at the same time (ie, you
	 * must sell the stock before you buy again). After you sell your stock, you
	 * cannot buy stock on next day. (ie, cooldown 1 day) Example:
	 * 
	 * prices = [1, 2, 3, 0, 2] maxProfit = 3 transactions = [buy, sell,
	 * cooldown, buy, sell]
	 * 
	 * DP equation
	 * buy[i] = max(sell[i-2] - price, buy[i-1]) 
	 * sell[i] = max(buy[i-1] + price, sell[i-1])
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_309BestTimetoBuyandSellStockwithCooldown in = new _309BestTimetoBuyandSellStockwithCooldown();
		in.maxProfit(new int[] { 1, 2, 3, 0, 2 });
	}

	public int maxProfit(int[] prices) {
		int buy = Integer.MIN_VALUE, pre_buy = 0, sell = 0, pre_sell = 0;
		for (int price : prices) {
			pre_buy = buy;
			buy = Math.max(pre_sell - price, pre_buy);
			pre_sell = sell;
			sell = Math.max(pre_buy + price, pre_sell);
		}
		return sell;
	}
	
	public int maxProfit1(int[] prices) {
        if (prices == null || prices.length <= 0) {
            return 0;
        }
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        buy[0] = -prices[0];
        buy[1] = Math.max(-prices[1], -prices[0]);
        sell[1] = Math.max(0,  prices[1] - prices[0]);
        for(int i=2;i<prices.length;i++)
        {
            sell[i]=Math.max(sell[i-1],prices[i]+buy[i-1]);
            buy[i]=Math.max(buy[i-1],sell[i-2]-prices[i]);
        }
        return sell[prices.length-1];
    }

}
