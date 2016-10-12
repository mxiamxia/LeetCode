package com.min.leetcode;

public class _5LongestPalindromString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_5LongestPalindromString in = new _5LongestPalindromString();
		in.longestPalindrome("abb");
	}

	public String longestPalindrome(String s) {

		String longestStr = null;
		if (s == null) {
			return null;
		}
		if (s.length() < 2) {
			return s;
		}

		longestStr = s.substring(0, 1);

		for (int i = 0; i < s.length(); i++) {
			// case "bab"
			String tmp = helper(s, i, i);
			if (tmp.length() > longestStr.length()) {
				longestStr = tmp;
			}

			// case "baab"
			tmp = helper(s, i, i + 1);
			if (tmp.length() > longestStr.length()) {
				longestStr = tmp;
			}
		}

		return longestStr;
	}

	public String helper(String s, int begin, int end) {
		while (begin >= 0 && end <= s.length() - 1 && s.charAt(begin) == s.charAt(end)) {
			begin--;
			end++;
		}
		return s.substring(begin + 1, end);
	}

}
