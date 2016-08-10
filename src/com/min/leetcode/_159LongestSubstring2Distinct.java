package com.min.leetcode;

import java.util.HashMap;
import java.util.Map;

public class _159LongestSubstring2Distinct {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int lengthOfLongestSubstringTwoDistinct(String s) {
		int max = 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int start = 0;
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			if (map.containsKey(c)) {
				map.put(c, map.get(c)+1);
			} else {
				map.put(c, 1);
			}
			while (map.size() > 2) {
				max = Math.max(max, i-start);
				char t = s.charAt(start);
				if (map.get(t) > 1) {
					map.put(t, map.get(t)-1);
				} else {
					map.remove(t);
				}
				start++;
			}
		}
		return Math.max(max, s.length()-start);
	}
}
