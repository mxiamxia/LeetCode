package com.min.leetcode;

public class _190ReverseBits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		reverseBits1(1);
	}

	public static int reverseBits1(int n) {
        int res = 0;
        for(int i=0; i<32; i++) {
            if ( (n & 1) == 1) {
            	res = res<<1 | 1;
            } else {
                res = res<<1;
            }
            n=n>>1;
        }
        return res;
    }
	
	public static int reverseBits(int n) {
        int res = 0;
        for(int i = 0; i < 32; i++, n >>= 1){
            res = res << 1 | (n & 1);
        }
        return res;
    }
}
