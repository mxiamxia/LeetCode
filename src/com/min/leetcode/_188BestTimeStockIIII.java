package com.min.leetcode;

public class _188BestTimeStockIIII {

	
	/*
	 * 
	 * 
	 * http://blog.csdn.net/fightforyourdream/article/details/14503469
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int len = prices.length;
        int[][] local = new int[len][k+1];
        int[][] globle = new int[len][k+1];
        for(int i=1; i<len; i++) {
            int diff = prices[i] - prices[i-1];
            for(int j=1; j<=k; j++) {
                local[i][j] = Math.max(globle[i-1][j-1] + Math.max(diff, 0), local[i-1][j]+diff);
                globle[i][j] = Math.max(globle[i-1][j], local[i][j]);
            }
        }
        return globle[len-1][k];
    }

}
