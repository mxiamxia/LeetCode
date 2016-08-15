package com.min.leetcode;

import java.util.HashMap;
import java.util.Map;

public class _170TwoSumIII {

	/**
	 * Design and implement a TwoSum class. It should support the following
	 * operations: add and find.
	 * 
	 * add - Add the number to an internal data structure. find - Find if there
	 * exists any pair of numbers which sum is equal to the value.
	 * 
	 * For example,
	 * 
	 * add(1); add(3); add(5); find(4) -> true find(7) -> false
	 * 
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	
	public void add(int n) {
		if (map.containsKey(n)) {
			map.put(n, map.get(n)+1);
		} else {
			map.put(n, 1);
		}
	}
	
	public boolean find(int n) {
		for(int i : map.keySet()) {
			int target = n - i;
			if (map.containsKey(target)) {
				// avoid case of 4+4 = 8 and only One 4 exist
				if (i == target && map.get(target) < 2) {
					continue;
				}
				return true;
			}
		}
		return false;
	}
}
