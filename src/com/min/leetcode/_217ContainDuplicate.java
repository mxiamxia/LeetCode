package com.min.leetcode;

import java.util.HashSet;
import java.util.Set;

public class _217ContainDuplicate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        Set<Integer> set = new HashSet<Integer>();
        for (int i=0; i<nums.length; i++) {
            if(!set.add(nums[i])) {
                return true;
            } 
        }
        return false;
    }
}
