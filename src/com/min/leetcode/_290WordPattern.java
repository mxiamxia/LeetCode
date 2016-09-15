package com.min.leetcode;

import java.util.HashMap;
import java.util.Map;

public class _290WordPattern {
	
	/*
	 * Given a pattern and a string str, find if str follows the same pattern.
		
		Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
		
		Examples:
		pattern = "abba", str = "dog cat cat dog" should return true.
		pattern = "abba", str = "dog cat cat fish" should return false.
		pattern = "aaaa", str = "dog cat cat dog" should return false.
		pattern = "abba", str = "dog dog dog dog" should return false.
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean wordPattern(String pattern, String str) {
        if(pattern == null || str == null) {
            return false;
        }
        String[] strArray = str.split("\\s+");
        if (pattern.length() != strArray.length) {
            return false;
        }
        Map<Character, String> map = new HashMap<Character, String>();
        for (int i=0; i<pattern.length(); i++) {
            char key = pattern.charAt(i);
            if (map.containsKey(key)) {
                if (!map.get(key).equals(strArray[i])) {
                    return false;
                }
            } else {
                if (map.containsValue(strArray[i])) {
                    return false;
                }
                map.put(key, strArray[i]);
            }
        }
        return true;
    }
}
