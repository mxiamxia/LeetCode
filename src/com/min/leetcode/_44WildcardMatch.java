package com.min.leetcode;

public class _44WildcardMatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_44WildcardMatch in = new _44WildcardMatch();
		in.isMatch("abcefgd",	"abc?**d");

	}

	public boolean isMatch(String s, String p) {
        if(p.length() == 0) {
            return s.length() == 0;
        }
        int star = -1;
        int mark = -1;
        int i = 0;
        int j = 0;
        while(i < s.length()) {
            if (j < p.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
                i++;
                j++;
            } else if(j < p.length() && p.charAt(j) == '*') {
                star = j;
                mark = i;
                j++;
            } else if(star != -1) {
                i = mark++;
                j = star+1;  // repeat start + 1 position until non start met
            } else {
                return false;
            }
        }
        while(j < p.length() && p.charAt(j) == '*') {
            j++;
        }
        
        return j == p.length();
    }
}
