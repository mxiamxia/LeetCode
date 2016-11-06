package com.min.backtracking;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Combinations {

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
//		Scanner in = new Scanner(System.in);
//		int n = in.nextInt();
//		int x = in.nextInt();
		int n = 3;
		int x = 10;
		int photos = combination(n);
		System.out.println(Math.abs(x - photos));
	}

	private static int combination(int n) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		dfs(n, 1, new ArrayList<Integer>(), res);
		return res.size();
	}

	private static void dfs(int n, int start, List<Integer> cur,
			List<List<Integer>> res) {
		res.add(new ArrayList<Integer>(cur));
		for (int i = start; i<=n; i++) {
			cur.add(i);
			dfs(n, i + 1, cur, res);
			cur.remove(cur.size() - 1);
		}
	}
}
