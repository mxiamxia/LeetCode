package com.min.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _386LexicographicalNumbers {

	/*
	 * Given an integer n, return 1 - n in lexicographical order.
	 * 
	 * For example, given 13, return: [1,10,11,12,13,2,3,4,5,6,7,8,9].
	 * 
	 * Please optimize your algorithm to use less time and space. The input size
	 * may be as large as 5,000,000.
	 * 
	 * 解法I 递归（Recursive）构造法
	 * 
	 * 优先将数字乘10；如果数字末位＜9，考虑将数字加1
	 * 
	 * 递归式类似于二叉树的先根遍历
	 * 
	 * 伪代码如下：
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_386LexicographicalNumbers in = new _386LexicographicalNumbers();
		in.lexicalOrder(150);
	}

	private List<Integer> result;
	private int n;

	public List<Integer> lexicalOrder(int n) {
		this.result = new ArrayList<Integer>();
		this.n = n;
		solve(1);
		return result;
	}

	private void solve(int m) {
		result.add(m);
		if (m * 10 <= n)
			solve(m * 10);
		if (m < n && m % 10 < 9)
			solve(m + 1);
	}

}
