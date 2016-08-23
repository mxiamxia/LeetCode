package com.min.leetcode;

public class _221MaximalSquare {

	/*
	 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing all 1's and return its area.

		For example, given the following matrix:
		
		1 0 1 0 0
		1 0 1 1 1
		1 1 1 1 1
		1 0 0 1 0
		Return 4.
	 * 
	 * 
	 * 当我们判断以某个点为正方形右下角时最大的正方形时，那它的上方，左方和左上方三个点也一定是某个正方形的右下角，
	 * 否则该点为右下角的正方形最大就是它自己了。这是定性的判断，那具体的最大正方形边长呢？我们知道，该点为右下角的正方形的最大边长，最多比它的上方，
	 * 左方和左上方为右下角的正方形的边长多1，最好的情况是是它的上方，左方和左上方为右下角的正方形的大小都一样的，这样加上该点就可以构成一个更大的正方形
	 * 。但如果它的上方，左方和左上方为右下角的正方形的大小不一样，合起来就会缺了某个角落，这时候只能取那三个正方形中最小的正方形的边长加1了。
	 * 假设dpi表示以i,j为右下角的正方形的最大边长，则有
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		maximalSquare(new char[][] { { '1' } });
	}

	public static int maximalSquare(char[][] matrix) {
		if (matrix == null || matrix.length == 0) {
			return 0;
		}
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] dp = new int[m][n];
		for (int i = 0; i < m; i++) {
			dp[i][0] = Character.getNumericValue(matrix[i][0]);
		}
		for (int i = 0; i < n; i++) {
			dp[0][i] = Character.getNumericValue(matrix[0][i]);
		}
		int max = 0;
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (matrix[i][j] == '1') {
					int min = Math.min(dp[i - 1][j - 1], dp[i - 1][j]);
					dp[i][j] = Math.min(min, dp[i][j - 1]) + 1;
				} else {
					dp[i][j] = 0;
				}

			}
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				max = Math.max(max, dp[i][j]);
			}
		}

		return max * max;
	}

}
