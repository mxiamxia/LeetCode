package com.min.backtracking;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class _40CombinationSumII {
	/*
	 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8, 
A solution set is: 
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
	 */
	
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
            tmp.sort(new Comparator<Integer>(){
    			@Override
    			public int compare(Integer o1, Integer o2) {
    				return o1 - o2;
    			}});
            if (!res.contains(tmp)) {
                res.add(tmp);
            }
            return;
        }
        for (int i=index; i<candidates.length; i++) {
            int v = candidates[i];
            cur.add(v);
            dfs(candidates, target, i+1, sum+v, res, cur);
            cur.remove(cur.size()-1);
        }
    }

}
