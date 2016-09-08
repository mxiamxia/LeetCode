package com.min.leetcode;

import java.util.HashMap;

public class _242ValidAnagram {

/*
 * Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.
 * 
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        int[] array = new int[26];
        for(int i=0; i<s.length(); i++) {
            array[s.charAt(i) - 'a']++;
            array[t.charAt(i) - 'a']--;
        }
        for(int c : array) {
            if (c != 0) {
                return false;
            }
        }
        return true;
    }

	public boolean isAnagramUnicode(String s, String t) {
	    if(s.length()!=t.length())
	        return false;
	 
	    HashMap<Character, Integer> map = new HashMap<Character, Integer>();    
	 
	    for(int i=0; i<s.length(); i++){
	        char c1 = s.charAt(i);
	        if(map.containsKey(c1)){
	            map.put(c1, map.get(c1)+1);
	        }else{
	            map.put(c1,1);
	        }
	    }
	 
	    for(int i=0; i<s.length(); i++){
	        char c2 = t.charAt(i);
	        if(map.containsKey(c2)){
	            if(map.get(c2)==1){
	                map.remove(c2);
	            }else{
	                map.put(c2, map.get(c2)-1);
	            }
	        }else{
	            return false;
	        }    
	    }
	 
	    if(map.size()>0)
	        return false;
	 
	    return true;
	}
}
