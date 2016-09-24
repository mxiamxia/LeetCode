package com.min.leetcode;

public class _311SparseMatrixMultiplication {
	
	/*
	 * Given two sparse matrices A and B, return the result of AB.

You may assume that A's column number is equal to B's row number.

Example:

A = [
  [ 1, 0, 0],
  [-1, 0, 3]
]

B = [
  [ 7, 0, 0 ],
  [ 0, 0, 0 ],
  [ 0, 0, 1 ]
]



     |  1 0 0 |   | 7 0 0 |   |  7 0 0 |   |1*7+1*0+1*0        0*7+0*0+0*0   0*0+0*0+0*1|
AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 | = |-1*7+-1*0+-1*0     0*0+0*0+0*0   3*0+3*0+3*1|          
                  | 0 0 1 |
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int[][] multiply(int[][] A, int[][] B) {
		int aL = A.length;
		int aC = A[0].length;
		int bL = B.length;
		int[][] C = new int[aL][bL];
		for (int i=0; i<aL; i++) {
			for (int j=0; j<aC; j++) {
				if (A[i][j] == 0) {
					continue;
				}
				for (int k=0; k<bL; k++) {
					C[i][k] += A[i][j] * B[j][k];
				}
			}
		}
		return C;
	}

}
