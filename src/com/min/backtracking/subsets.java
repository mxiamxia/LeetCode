package com.min.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        List<Integer> cur = new ArrayList<Integer>();
        dfs(nums, res, cur, 0);
        return res;
    }
    private void dfs(int[] nums, List<List<Integer>> res, List<Integer> cur, int start) {
        if (cur.size() > 0) {
            List<Integer> tmp = new ArrayList<Integer>(cur);
            res.add(tmp);
        }
        if (cur.size() == nums.length) {
        	cur.clear();
        }
        for (int i=start; i<nums.length; i++) {
            cur.add(nums[i]);
            dfs(nums, res, cur, i+1);
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		subsets in = new subsets();
		in.subsets(new int[]{1, 2, 3});
	}

}
