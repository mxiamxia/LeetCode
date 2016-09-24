package com.min.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _320GeneralizedAbbreviation {
	
	/*
	 * Question:

Write a function to generate the generalized abbreviations of a word.

Example:
Given word = "word", return the following list (order does not matter):

["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", >"1o1d", "1or1", "w1r1", "1o2", "2r1", "3d","w3", "4"]
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_320GeneralizedAbbreviation in = new _320GeneralizedAbbreviation();
		in.generateAbbreviations("word");
	}

	public List<String> generateAbbreviations(String word) {
		List<String> res = new ArrayList<>();
		dfs(res, "", 0, word);
		return res;
	}


	public void dfs(List<String> res, String curr, int start, String s) {
		res.add(curr + s.substring(start));
		if (start == s.length())
			return;

		// 定义新的起始位置
		int i = 0;

		// 除了最开始，起始位置都要与之前结尾位置隔一个
		if (start > 0) {
			i = start + 1;
		}

		for (; i < s.length(); i++) {
			String prefix = curr + s.substring(start, i);
			// 以ith字符开头，依次替换j个字母成数字。
			for (int j = 1; j <= s.length() - i; j++) {
				dfs(res, prefix + j, i + j, s);
				// i+j,表示从上一个start开始替换j个字母后开始的字母位置。
			}
		}
	}
}
