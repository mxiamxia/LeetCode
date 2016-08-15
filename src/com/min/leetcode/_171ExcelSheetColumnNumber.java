package com.min.leetcode;

public class _171ExcelSheetColumnNumber {

	/*
	 * Given a column title as appear in an Excel sheet, return its
	 * corresponding column number.
	 * 
	 * For example:
	 * 
	 * A -> 1 B -> 2 C -> 3 ... Z -> 26 AA -> 27 AB -> 28
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(titleToNumber("AAA"));
	}

	public static int titleToNumber(String s) {
		int len = s.length();
		int res = 0;
		int t = 0;
		for (int i = len - 1; i >= 0; i--) {
			res += (s.charAt(i) - 'A' + 1) * Math.pow(26, t);
			t++;
		}
		return res;
	}
}
