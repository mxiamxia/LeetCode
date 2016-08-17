package com.min.leetcode;

import java.util.HashMap;
import java.util.Map;

public class _205IsomorphicStrings {

	/*
	 * Given two strings s and t, determine if they are isomorphic.
	 * 
	 * Two strings are isomorphic if the characters in s can be replaced to get
	 * t.
	 * 
	 * All occurrences of a character must be replaced with another character
	 * while preserving the order of characters. No two characters may map to
	 * the same character but a character may map to itself.
	 * 
	 * For example, Given "egg", "add", return true.
	 * 
	 * Given "foo", "bar", return false.
	 * 
	 * Given "paper", "title", return true.
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isIsomorphic("a", "a"));
	}
	
	public static boolean isIsomorphic(String s, String t) {
        if(s==null||t==null)
            return false;
     
        if(s.length()!=t.length())
            return false;
     
        HashMap<Character, Character> map = new HashMap<Character, Character>();
     
     
        for(int i=0; i<s.length(); i++){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
     
            if(map.containsKey(c1)){
                if(map.get(c1)!=c2)// if not consistant with previous ones
                    return false;
            }else{
                if(map.containsValue(c2)) //if c2 is already being mapped
                    return false;
                map.put(c1, c2);
            }
        }
     
        return true;
    }

	public static boolean isIsomorphic1(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> mapS = new HashMap<Character, Integer>();
        Map<Character, Integer> mapT = new HashMap<Character, Integer>();
        int i=0;
        while(i < s.length()) {
            char sc = s.charAt(i);
            if(mapS.containsKey(sc)) {
                int idx = mapS.get(sc);
                char st = t.charAt(i);
                if (st != t.charAt(idx)) {
                    return false;
                }
            }
            mapS.put(sc, i);
            i++;
        }
        
        int j=0;
        while(j < t.length()) {
            char st = t.charAt(j);
            if(mapT.containsKey(st)) {
                int idx = mapT.get(st);
                char sc = s.charAt(j);
                if (sc != s.charAt(idx)) {
                    return false;
                }
            } 
            mapT.put(st, j);
            j++;
        }
        return true;
    }
}
