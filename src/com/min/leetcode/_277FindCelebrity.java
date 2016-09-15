package com.min.leetcode;

public class _277FindCelebrity {

	/*
	 * Total Accepted: 1126 Total Submissions: 3603 Difficulty: Medium Suppose
	 * you are at a party with n people (labeled from 0 ton - 1) and among them,
	 * there may exist one celebrity. The definition of a celebrity is that all
	 * the othern - 1 people know him/her but he/she does not know any of them.
	 * Now you want to find out who the celebrity is or verify that there is not
	 * one. The only thing you are allowed to do is to ask questions like:
	 * "Hi, A. Do you know B?" to get information of whether A knows B. You need
	 * to find out the celebrity (or verify there is not one) by asking as few
	 * questions as possible (in the asymptotic sense). You are given a helper
	 * function bool knows(a, b) which tells you whether A knows B. Implement a
	 * functionint findCelebrity(n), your function should minimize the number of
	 * calls toknows. Note: There will be exactly one celebrity if he/she is in
	 * the party. Return the celebrity's label if there is a celebrity in the
	 * party. If there is no celebrity, return-1.
	 * 
	 * [思路] 当 a -> b时, 可以推出, a不可能是celebrity, b被人知道的数目+1... 用bitmap记录.
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int findCelebrity(int n) {
		int[] count = new int[n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j)
					continue;
				if (count[i] >= 0) {
					if (know(i, j)) {
						count[i] = -1;
						count[j]++;
					} else {
						count[j] = -1;
					}
				}
			}
		}
		for (int i = 0; i < n; i++) {
			if (count[i] == n - 1) {
				for (int j = 0; j < n; j++) {
					if (know(i, j)) {
						return -1;
					} else {
						return i;
					}
				}
			}
			return -1;
		}
	}
}
