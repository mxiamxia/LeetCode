package com.min.leetcode;

public class _345ReverseVowelsString {

	/*
	 * Write a function that takes a string as input and reverse only the vowels
	 * of a string.
	 * 
	 * Example 1: Given s = "hello", return "holle".
	 * 
	 * Example 2: Given s = "leetcode", return "leotcede".
	 * 
	 * Solution
	 * two pointer
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String reverseVowels(String s) {
		if (s == null) {
			return null;
		}
		if (s == "") {
			return "";
		}
		int i = 0, j = s.length() - 1;
		char[] array = s.toCharArray();
		while (i < j) {
			if (isVowels(array[i]) && isVowels(array[j])) {
				char tmp = array[i];
				array[i] = array[j];
				array[j] = tmp;
				i++;
				j--;
			}
			if (!isVowels(array[i])) {
				i++;
			}
			if (!isVowels(array[j])) {
				j--;
			}
		}
		return new String(array);
	}

	private boolean isVowels(char c) {
		String v = "aeiouAEIOU";
		if (v.indexOf(c) > -1) {
			return true;
		}
		return false;
	}

}
