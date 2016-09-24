package com.min.leetcode;

public class _326PowerofThree {
	
	/*
	 * Given an integer, write a function to determine if it is a power of three.
		
		Follow up:
		Could you do it without using any loop / recursion?
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        if (n % 3 == 0) {
            return isPowerOfThree(n/3);
        }
        return false;
    }

}
