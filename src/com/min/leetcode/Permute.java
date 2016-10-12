package com.min.leetcode;

import java.util.ArrayList;
import java.util.List;


public class Permute {

	/** 
	 * @author Min
	 * @date Jul 22, 2015
	 * @return void 
	 * @throws 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = new int[]{0, 1, 2};
		Permute in = new Permute();
		System.out.println(in.permute(input));
	}
	
	public List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>(); 
        if(nums == null || nums.length == 0) {
            return res;
        }
        recursivePermute(nums, 0, new ArrayList<Integer>(), res);
        return res;
    }
    
    public void recursivePermute(int[] nums, int start, ArrayList<Integer> cur, ArrayList<List<Integer>> res) {
        if(cur.size() == nums.length) {
            ArrayList<Integer> tmp = new ArrayList<Integer>(cur);
            res.add(tmp);
            return;
        }
        for(int i=start; i<nums.length; i++) {
                cur.add(nums[i]);
                recursivePermute(nums, i+1, cur, res);
                cur.remove(cur.size()-1);
        }
    }

}
