package com.min.leetcode;

public class _372SuperPow {

	/**
	Your task is to calculate ab mod 1337 where a is a positive integer and b is an extremely large positive integer given in the form of an array.

	Example1:

	a = 2
	b = [3]

	Result: 8
	Example2:

	a = 2
	b = [1,0]

	Result: 1024
	*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int superPow(int a, int[] b) {
        return superPow(a, b, b.length, 1337);
    }
    
    private static int superPow(int a, int[] b, int length, int k) {
        if (length == 1) {
            return powMod(a, b[0], k);
        }
        
        return powMod(superPow(a, b, length - 1, k), 10, k) * powMod(a, b[length - 1], k) % k;
    }
    
    
    //x^y mod k
    private static int powMod(int x, int y, int k) {
        x %= k;
        int pow = 1;
        for (int i = 0; i < y; i++) {
            pow = (pow * x) % k;
        }
        return pow; 
    }
	
	
//	static int superPow(int a, int[] b) {
//        int res = 1;
//        for (int i = 0; i < b.length; ++i) {
//            res = pow(res, 10) * pow(a, b[i]) % 1337;
//        }
//        return res;
//    }
//	static int pow(int x, int n) {
//        if (n == 0) return 1;
//        if (n == 1) return x % 1337;
//        return pow(x % 1337, n / 2) * pow(x % 1337, n - n / 2) % 1337;
//    }

}
