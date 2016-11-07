package com.min.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _438FindAllAnagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_438FindAllAnagram in = new _438FindAllAnagram();
		in.findAnagrams("cbaebabacd", "abc");
	}
	
	public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<Integer>();
        int count = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i=0; i<p.length(); i++) {
            char c = p.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c)+1);
            } else {
                map.put(c, 1);
            }
        }
        int start = 0;
        for(int end=0; end<s.length(); end++) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
            	if (map.get(c)>0) {
            		count++;
            	}
                map.put(c, map.get(c)-1);
            }
            if (count == p.length()) {
                res.add(start);
            }
            if ((end-start) == p.length()-1) {
                char st = s.charAt(start);
                if (map.containsKey(st)) {
                	if (map.get(st) >=0 ) {
                		count--;
                	}
                    map.put(st, map.get(st)+1);
                }
                start++;
            }
        }
        return res;
    }

}
