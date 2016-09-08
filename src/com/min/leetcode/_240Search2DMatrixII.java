package com.min.leetcode;

public class _240Search2DMatrixII {
	
	/*
	 * 
	 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

	Integers in each row are sorted in ascending from left to right.
	Integers in each column are sorted in ascending from top to bottom.
	For example,
	
	 从右上角开始找，大于当前值 往左移， 小于当前值向下移


	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0;
        int j = n-1;
        while (i < m && j >=0) {
            int x = matrix[i][j];
            if (x == target) {
                return true;
            } else if (x < target) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }

}
