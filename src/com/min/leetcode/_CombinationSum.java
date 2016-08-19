package com.min.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _CombinationSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		combinationSum(new int[]{2,3,6,7}, 7);
	}
	
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<List<Integer>> ret = new ArrayList<List<Integer>>();
        if(candidates == null || candidates.length == 0) {
            return ret;
        }
        Arrays.sort(candidates);
        ArrayList<Integer> cur = new ArrayList<Integer>();
        combinationSumDFS(candidates, 0, target, cur, ret);
        return ret;
    }
    
    public static void combinationSumDFS(int[] candidates, int index, int target, ArrayList<Integer> cur, ArrayList<List<Integer>> ret) {
        if(target == 0) {
            ArrayList<Integer> temp = new ArrayList<Integer>(cur);
            ret.add(temp);
            return;
        }
        for(int i = index; i <= candidates.length - 1; i++) {
            if(candidates[i] > target) {
                return;
            }
            cur.add(candidates[i]);
            combinationSumDFS(candidates, i, target - candidates[i], cur, ret);
            cur.remove(cur.size()-1);
        }
    }

}
