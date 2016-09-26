package com.min.leetcode;

public class _338CountBits {
	/*
	 * Given a non negative integer number num. For every numbers i in the range
	 * 0 ≤ i ≤ num calculate the number of 1's in their binary representation
	 * and return them as an array.
	 * 
	 * Example: For num = 5 you should return [0,1,1,2,1,2].
	 * 
	 * http://www.programcreek.com/2015/03/leetcode-counting-bits-java/
	 * 
	 * Hint:
	 * 
	 * You should make use of what you have produced already. Divide the numbers
	 * in ranges like [2-3], [4-7], [8-15] and so on. And try to generate new
	 * range from previous. Or does the odd/even status of the number help you
	 * in calculating the number of 1s?
	 * 
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] countBits(int num) {
		int[] res = new int[num + 1];
		int p = 1;
		int pow = 1;
		for (int i = 1; i <= num; i++) {
			if (i == pow) {
				res[i] = 1;
				pow = pow << 1;
				p = 1;
			} else {
				res[i] = res[p] + 1;
				p++;
			}
		}
		return res;
	}

}
