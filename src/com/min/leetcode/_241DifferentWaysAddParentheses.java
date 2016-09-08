package com.min.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _241DifferentWaysAddParentheses {
	
	
	/*
	 * Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. The valid operators are +, - and *.
		这道题主要思想是Divide and Conquer 分治法
		对于一个表达式 a - b, a与b均为表达式，计算a - b的结果 我们需要先知道a的结果与b的结果。对于知道加parentheses的题，只要对表达中的每一个运算符都做这样的操作并递归，就可以得出所有可能结果，希望下面的例子可以帮助理解

                        2 * 3 - 4 * 5
                            /        \
              2 * (3 - 4 * 5)        ...
                        /     \
              (3 - 4 ) * 5     3 - (4 * 5)
               /    \
               3     4

	 * 
	 * 
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		diffWaysToCompute("2*3-4");
	}

	public static List<Integer> diffWaysToCompute(String input) {
		List<Integer> res = new ArrayList<Integer>();
		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			if (ch == '+' || ch == '-' || ch == '*') {
				List<Integer> left = diffWaysToCompute(input.substring(0, i));
				List<Integer> right = diffWaysToCompute(input.substring(i + 1));
				for (int n : left) {
					for (int m : right) {
						switch (ch) {
						case '+':
							res.add(n + m);
							break;
						case '-':
							res.add(n - m);
							break;

						case '*':
							res.add(n * m);
							break;
						}
					}
				}
			}
		}

		if (res.size() == 0) {
			res.add(Integer.parseInt(input));
		}

		return res;
	}
}
