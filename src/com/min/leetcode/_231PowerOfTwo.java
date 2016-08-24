package com.min.leetcode;

public class _231PowerOfTwo {
	
	/*
	 * Given an integer, write a function to determine if it is a power of two.
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public boolean isPowerOfTwo(int n) {
        if (n < 1) {
            return false;
        }
        if ((n & (n-1)) == 0) {
            return true;
        }
        return false;
    }
	
	//move right 1 bit and move left 1 bit to see they are equal. such as 1100 then false; 
	//power of two must be only one '1' ex, 10000
	public boolean isPowerOfTwo2(int n) {
	    if(n<=0) 
	        return false;
	 
	    while(n>2){
	        int t = n>>1;
	        int c = t<<1;
	 
	        if(n-c != 0)
	            return false;
	 
	        n = n>>1;
	    }
	 
	    return true;
	}

}
