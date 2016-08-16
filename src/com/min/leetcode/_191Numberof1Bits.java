package com.min.leetcode;

public class _191Numberof1Bits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		hammingWeight(2);
	}
	
	public static int hammingWeight(int n) {
        int count = 0;
        for(int i=0; i<32; i++) {
            if ((n & 1) == 1) {
                count++;
            } 
            n = n>>1;
        }
        return count;
    }
	
	public int hammingWeight1(int n) {
        if (n == 0) {
            return 0;
        }
        
        int count = 1;
        while ((n & (n - 1)) != 0) {
            n &= n-1;
            count++;
        }
        return count;
    }

}
