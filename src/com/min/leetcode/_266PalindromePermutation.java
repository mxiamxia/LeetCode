package com.min.leetcode;

public class _266PalindromePermutation {
	/*
	 * Given a string, determine if a permutation of the string could form a
	 * palindrome.
	 * 
	 * For example, "code" -> False, "aab" -> True, "carerac" -> True.
	 * 
	 * Hint:
	 * 
	 * Consider the palindromes of odd vs even length. What difference do you
	 * notice? 
	 * Count the frequency of each character. 
	 * If each character occurs even number of times, then it must be a palindrome. How about character
	 * which occurs odd number of times?
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_266PalindromePermutation in = new _266PalindromePermutation();
		System.out.println(in.canPermutePalindrome("carerac"));
	}
	public boolean canPermutePalindrome(String s) {
		if (s == null || s.length() == 0) {
			return false;
		}
		int [] c = new int[256];
		int count = 0;
		for(int i=0; i<s.length(); i++) {
			if (c[s.charAt(i)] == 1) {
				c[s.charAt(i)]--;
				count--;
			} else {
				c[s.charAt(i)]++;
				count++;
			}
		}
		return count <= 1;
	}

}
