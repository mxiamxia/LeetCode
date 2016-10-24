package com.min.binarysearch;

public class _74Search2dMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_74Search2dMatrix in = new _74Search2dMatrix();
		in.searchMatrix(new int[][]{{1, 3}},  2);
	}
	
	public boolean searchMatrix(int[][] matrix, int target) {
        if (target < matrix[0][0]) {
            return false;
        }
        for (int i=0; i<matrix.length; i++) {
            if (target >= matrix[i][0] && target <= matrix[i][matrix[0].length-1]) {
                return binaryFind(matrix[i], target, 0, matrix[0].length-1);
            }
        }
        return false;
    }
    private boolean binaryFind(int[] row, int target, int start, int end) {
        
        while (start <= end) {
        	int mid = start + (end - start) / 2;
            if (row[mid] == target) {
                return true;
            } else if (row[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }

}
