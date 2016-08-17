package com.min.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _187RepeatDNASeq {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		hashCode("CCCCC");
	}
	
	public List<String> findRepeatedDnaSequences1(String s) {
        List<String> res = new ArrayList<String>();
        if (s == null || s.length() < 10) {
            return res;
        }
        Set<String> set = new HashSet<String>();
        for(int i=10; i<=s.length(); i++) {
            String str = s.substring(i-10, i);
            if (set.contains(str) && !res.contains(str)) {
                res.add(str);
            } else {
                set.add(str);
            }
        }
        return res;
    }
	
	public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<String>();
        if (s == null || s.length() < 10) {
            return res;
        }
        Set<Integer> set = new HashSet<Integer>();
        for(int i=10; i<=s.length(); i++) {
            String str = s.substring(i-10, i);
            int code = hashCode(str);
            if (set.contains(code) && !res.contains(str)) {
                res.add(str);
            } else {
                set.add(code);
            }
        }
        return res;
    }
	
	private static int hashCode(String str) {
        int hash = 0;

        for (int i = 0; i < str.length(); i ++) {
            hash = hash << 2 | mapInteger(str.charAt(i));
        }

        return hash;
    }

    private static int mapInteger(char ch) {
        switch (ch) {
        case 'A':
            // 00
            return 0;
        case 'C':
            // 01
            return 1;
        case 'G':
            // 10
            return 2;
        case 'T':
            // 11
            return 3;
        default :
            return 0;
        }
    }

}
