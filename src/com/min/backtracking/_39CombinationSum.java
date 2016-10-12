package com.min.backtracking;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class _39CombinationSum {
	
	/*
	 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [2, 3, 6, 7] and target 7, 
A solution set is: 
[
  [7],
  [2, 2, 3]
]
	 */
	
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (candidates.length == 0 || target < 0) {
            return res;
        }
        List<Integer> cur = new ArrayList<Integer>();
        dfs(candidates, target, 0, 0, res, cur);
        return res;
    }
    private void dfs(int[] candidates, int target, int index, int sum, List<List<Integer>> res, List<Integer> cur) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            List<Integer> tmp = new ArrayList<Integer>(cur);
            res.add(tmp);
            return;
        }
        for (int i=index; i<candidates.length; i++) {
            int v = candidates[i];
            cur.add(v);
            dfs(candidates, target, i, sum+v, res, cur);
            cur.remove(cur.size()-1);
        }
    }

}
