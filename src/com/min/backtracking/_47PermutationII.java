package com.min.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class _47PermutationII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_47PermutationII in = new _47PermutationII();
		in.permuteUnique(new int[]{1, 1, 2});
	}
	
	 public  List<List<Integer>> permuteUnique(int[] nums) {
	        List<List<Integer>> res = new ArrayList<List<Integer>>();
	        if (nums == null || nums.length == 0) {
	            return res;
	        }
	        Arrays.sort(nums);
	        List<Integer> cur = new ArrayList<Integer>();
	        boolean[] flag = new boolean[nums.length];
	        dfs(nums, nums.length, flag, res, cur);
	        return res;
	    }
	    private void dfs(int[] nums, int len, boolean[] flag, List<List<Integer>> res, List<Integer> cur) {
	        if (len == 0 ) {
	            List<Integer> tmp = new ArrayList<Integer>(cur);
	            res.add(tmp);
	            return;
	        }
	        for (int i=0; i<nums.length; i++) {
	            if (!flag[i]) {
	            	// because it backtrack from the beginning. the same number do not need to backtrack again. it will generate the same permutaion.
	                if (i>0 && nums[i] == nums[i-1] && !flag[i-1]) {  // if the same number and last one is not visited, skip the current one. it will skill whole round of this digit from the beginning
	                    continue;
	                }
	                flag[i] = true;
	                cur.add(nums[i]);
	                dfs(nums, len-1, flag, res, cur);
	                cur.remove(cur.size()-1);
	                flag[i] = false;
	            }
	        }
	    }

}
