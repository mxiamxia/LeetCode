package com.min.leetcode;

import java.util.Arrays;

public class _274HIndex {

	/*
	 * Given an array of citations (each citation is a non-negative integer) of
	 * a researcher, write a function to compute the researcher's h-index.
	 * 
	 * According to the definition of h-index on Wikipedia:
	 * "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."
	 * 
	 * For example, given citations = [3, 0, 6, 1, 5], which means the
	 * researcher has 5 papers in total and each of them had received 3, 0, 6,
	 * 1, 5 citations respectively. Since the researcher has 3 papers with at
	 * least 3 citations each and the remaining two with no more than 3
	 * citations each, his h-index is 3.
	 * 
	 * Note: If there are several possible values for h, the maximum one is
	 * taken as the h-index.
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * 思路 先将数组排序，我们就可以知道对于某个引用数，有多少文献的引用数大于这个数。对于引用数citations[i]，
	 * 大于该引用数文献的数量是citations.length - i，而当前的H-Index则是Math.min(citations[i],
	 * citations.length - i)，我们将这个当前的H指数和全局最大的H指数来比较，得到最大H指数。
	 */

	public int hIndex(int[] citations) {
		if (citations == null || citations.length == 0) {
			return 0;
		}
		Arrays.sort(citations);
		int h = 0;
		for (int i = 0; i < citations.length; i++) {
			int curH = Math.min(citations[i], citations.length - i);
			if (h < curH) {
				h = curH;
			}
		}
		return h;
	}

}
