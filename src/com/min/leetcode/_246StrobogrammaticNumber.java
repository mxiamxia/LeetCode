package com.min.leetcode;

import java.util.HashMap;
import java.util.Map;

public class _246StrobogrammaticNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static boolean isStrobogrammatic(String num) {
		HashMap<Character, Character> map = new HashMap<Character, Character>();
        map.put('1','1');
        map.put('0','0');
        map.put('6','9');
        map.put('9','6');
        map.put('8','8');
		int left = 0, right = num.length()-1;
		while (left <= right) {
			if (!map.containsKey(num.charAt(left)) || map.get(num.charAt(left)) != map.get(num.charAt(right))) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
}
