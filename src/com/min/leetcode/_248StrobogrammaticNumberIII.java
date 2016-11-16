package com.min.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _248StrobogrammaticNumberIII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_248StrobogrammaticNumberIII in = new _248StrobogrammaticNumberIII();
		System.out.println(in.strobogrammaticInRange("160", "162"));
		System.out.println(in.strobogrammaticInRange2("0", "9"));

	}
	private int count = 0;
    private Map<Character, Character> map = new HashMap<>();
    List<String> res = new ArrayList<String>();
     
    public int strobogrammaticInRange(String low, String high) {
        if (low == null || low.length() == 0 || high == null || high.length() == 0) {
            return 0;
        }
         
        fillMap();
         
        for (int n = low.length(); n <= high.length(); n++) {
            char[] arr = new char[n];
            getStrobogrammaticNumbers(arr, 0, n - 1, low, high);
        }
        System.out.println(res);
         
        return count;
    }
     
    private void getStrobogrammaticNumbers(char[] arr, int start, int end, String low, String high) {
        if (start > end) {
            String s = new String(arr);
            if ((s.length() == 1 || s.charAt(0) != '0') && compare(low, s) && compare(s, high)) {
            	res.add(s);
                count++;
            }
            return;
        }
             
        for (char c : map.keySet()) {
            arr[start] = c;
            arr[end] = map.get(c);
                 
            if ((start < end) || (start == end && map.get(c) == c)) {
                getStrobogrammaticNumbers(arr, start + 1, end - 1, low, high);
            }
        }
    }
     
    // Return true if s1 <= s2
    private boolean compare(String s1, String s2) {
        if (s1.length() == s2.length()) {
            if (s1.compareTo(s2) <= 0) {
                return true;
            } else {
                return false;
            }
        }
         
        return true;
    }
     
    private void fillMap() {
        map.put('0', '0');
        map.put('1', '1');
        map.put('8', '8');
        map.put('6', '9');
        map.put('9', '6');
    }
    
    
    
    
    public int strobogrammaticInRange2(String low, String high) {
        int count = 0;
        for (int i=Integer.parseInt(low); i<=Integer.parseInt(high); i++) {
            if (isStrobogrammatic(String.valueOf(i))) {
                count++;
            }
        }
        return count;
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
