package com.min.leetcode;

public class _387FindFirstUnqiueChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_387FindFirstUnqiueChar in = new _387FindFirstUnqiueChar();
		in.firstUniqChar("loveleetcode");
	}
	
	public int firstUniqChar(String s) {
        int res = -1;
        if (s == null || s.length() == 0) {
            return res;
        }
        int[][] flag = new int[s.length()][26];
        for (int i=0; i<s.length(); i++) {
            flag[i][s.charAt(i)-'a']++;
        }
        for (int i=0; i<s.length(); i++) {
            if (flag[i][s.charAt(i)-'a'] == 1) {
                return i;
            }
        }
        return res;
    }

}
