package com.min.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _204CountPrimes {

	/*
	 * Count the number of prime numbers less than a non-negative number, n.
	 * 
	 * 
	 * 如果一个数是另一个数的倍数，那这个数肯定不是素数。利用这个性质，我们可以建立一个素数数组，从2开始将素数的倍数都标注为不是素数。第一轮将4、6、
	 * 8等表为非素数，然后遍历到3，发现3没有被标记为非素数，则将6、9、12等标记为非素数，一直到N为止，再数一遍素数数组中有多少素数。
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countPrimes(10000));
	}

	public static int countPrimes(int n) {
		boolean[] flag = new boolean[n];
		Arrays.fill(flag, true);
		for (int i = 2; i < n; i++) {
			for (int j = i * 2; j < n; j = j + i) {
				if (flag[j]) {
					flag[j] = false;
				}
			}
		}
		int count = 0;
		for (int k = 2; k < n; k++) {
			if (flag[k]) {
				count++;
			}
		}
		return count;
	}

}
