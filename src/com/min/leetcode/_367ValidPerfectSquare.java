package com.min.leetcode;

public class _367ValidPerfectSquare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean isPerfectSquare(int num) {
        if (num == 1) {
            return true;
        }
        for(int i=1; i<=num/i; i++) {
            if (i * i == num) {
                return true;
            }
        }
        return false;
    }

}
