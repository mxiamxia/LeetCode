package com.min.leetcode;

public class _459RepeatedSubPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_459RepeatedSubPattern in = new _459RepeatedSubPattern();
		in.repeatedSubstringPattern("abab");
	}
	
	public boolean repeatedSubstringPattern(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        for (int i=1; i<=str.length()/2; i++) {
            String pattern = str.substring(0, i);
            for (int j=i; j<=str.length()-i; j+=i) {
                if (!pattern.equals(str.substring(j, j+i))) {
                    break;
                }
                if ((j+i) == str.length()) {
                    return true;
                }
            }
            
        }
        return false;
    }

}
