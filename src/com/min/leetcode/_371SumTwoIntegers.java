package com.min.leetcode;

public class _371SumTwoIntegers {
	public static void main(String[] args) {
		System.out.println(getSum(3, 5));
	}

	public static int getSum(int a, int b) {
		while (b != 0) {
			int c = a & b; // carry
			a ^= b; // add
			b = c << 1;
		}
		return a;
	}
}
