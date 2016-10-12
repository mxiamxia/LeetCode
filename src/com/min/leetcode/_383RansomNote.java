package com.min.leetcode;

import java.util.Arrays;

public class _383RansomNote {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_383RansomNote in = new _383RansomNote();
		in.canConstruct("aa", "aab");
	}
	
	public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length() || magazine.equals("") ){
            return false;
        }
        char[] r = ransomNote.toCharArray();
        char[] m = magazine.toCharArray();
        Arrays.sort(r);
        Arrays.sort(m);
        for (int i=0; i<r.length; i++) {
            if (r[i] != m[i]) {
                return false;
            }
        }
        return true;
    }

}
