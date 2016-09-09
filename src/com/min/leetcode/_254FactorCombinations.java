package com.min.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _254FactorCombinations {

	/*
	 * Numbers can be regarded as product of its factors. For example,
	 * 
	 * 8 = 2 x 2 x 2; = 2 x 4. Write a function that takes an integer n and
	 * return all possible combinations of its factors.
	 * 
	 * Note: You may assume that n is always positive. Factors should be greater
	 * than 1 and less than n.
	 * 
	 * 
	 * O(2^N) 时间 O(N) 空间
	 * 思路 递归，为了防止2,2,3和2,3,2这种重复，参数里需要一个start 递归函数接口定义：
	 * 
	 * helper函数找n的所有因式分解，每个因式分解最小的因子从start开始，后面的因子们升序排列，把所有这样的因式分解放到result里
	 * 
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_254FactorCombinations in = new _254FactorCombinations();
		// System.out.println(in.getFactors(8));
		System.out.println(in.getFactors1(8));
	}

	public List<List<Integer>> getFactors(int n) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		helper(ret, new ArrayList<Integer>(), n, 2);
		return ret;
	}

	private void helper(List<List<Integer>> ret, List<Integer> item, int n, int start) {
		if (n == 1) {
			if (item.size() > 1) {
				ret.add(new ArrayList<Integer>(item));
			}
			return;
		}
		for (int i = start; i <= n; i++) {
			if (n % i == 0) {
				item.add(i);
				helper(ret, item, n / i, i);
				item.remove(item.size() - 1);
			}
		}
	}

	public List<List<Integer>> getFactors1(int n) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		helper1(n, 2, list, result);
		return result;
	}

	public void helper1(int n, int start, List<Integer> list, List<List<Integer>> result) {
		if (n == 1) {
			if (list.size() > 1) { // the original input is not counted in
				result.add(new ArrayList<Integer>(list));
			}
			return;
		}
		for (int i = start; i <= Math.sqrt(n); i++) { // 这里只要到根号n就好了
			if (n % i == 0) {
				list.add(i);
				helper1(n / i, i, list, result);
				list.remove(list.size() - 1);
			}
		}
		list.add(n); // 把n加进去
		helper1(1, n, list, result);
		list.remove(list.size() - 1);
	}

}
