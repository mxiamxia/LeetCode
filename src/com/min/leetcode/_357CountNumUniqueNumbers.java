package com.min.leetcode;

public class _357CountNumUniqueNumbers {

	/*
	 * 
	 * Given a non-negative integer n, count all numbers with unique digits, x,
	 * where 0 ≤ x < 10n.
	 * 
	 * Example: Given n = 2, return 91. (The answer should be the total numbers
	 * in the range of 0 ≤ x < 100, excluding [11,22,33,44,55,66,77,88,99])
	 * 
	 * 
	 * 这道题让我们找一个范围内的各位上不相同的数字，比如123就是各位不相同的数字，而11,121,222就不是这样的数字。
	 * 那么我们根据提示中的最后一条可以知道，一位数的满足要求的数字是10个(0到9)，二位数的满足题意的是81个，[10 -
	 * 99]这90个数字中去掉[11,22,33,44,55,66,77,88,99]这9个数字，还剩81个。通项公式为f(k) = 9 * 9 * 8
	 * * ... (9 - k + 2)，那么我们就可以根据n的大小，把[1, n]区间位数通过通项公式算出来累加起来即可，参见代码如下：
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_357CountNumUniqueNumbers in = new _357CountNumUniqueNumbers();
		in.countNumbersWithUniqueDigits(13);
	}

	public int countNumbersWithUniqueDigits(int n) {
		int[] arr = new int[n + 1];
		arr[0] = 1; // x can be 0

		for (int i = 1; i <= n; i++) {
			arr[i] = 9;
			for (int j = 9; j >= 9 - i + 2; j--) {
				arr[i] *= j;
			}
		}

		int result = 0;
		for (int i : arr)
			result += i;

		return result;
	}
}
