package com.min.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _216CombinationSumIII {
	/*
	 * Find all possible combinations of k numbers that add up to a number n,
	 * given that only numbers from 1 to 9 can be used and each combination
	 * should be a unique set of numbers.
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		combinationSum3(3, 7);
	}

	public static List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> cur = new ArrayList<Integer>();
		helper(res, cur, 1, k, n);
		return res;
	}

	private static void helper(List<List<Integer>> res, List<Integer> cur, int start, int k, int n) {
		if (n < 0) {
			return;
		}
		if (n == 0 && cur.size() == k) {
			List<Integer> tmp = new ArrayList<Integer>(cur);
			res.add(tmp);
			return;
		}
		for (int i = start; i < 9; i++) {
			if (n < i) {
				return;
			}
			cur.add(i);
			helper(res, cur, i + 1, k, n - i);
			cur.remove(cur.size()-1);
		}
	}

}
