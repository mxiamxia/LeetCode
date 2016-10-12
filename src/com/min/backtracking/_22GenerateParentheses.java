package com.min.backtracking;

public class _22GenerateParentheses {
	/*
	 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
	 */

	
	public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        if (n < 1) {
            return res;
        }
        dfs(n, "", 0, 0, res);  //number, pair, left, right, list
        return res;
    }
    private void dfs(int n, String s, int l, int r, List<String> res) {
        if (l > n || r > n) {
            return;
        }
        if (l == n && r == n) {
            res.add(s);
        }
        dfs(n, s+"(", l+1, r, res);
        if (l > r) {
            dfs(n, s+")", l, r+1, res);
        }
    }
}
