package com.min.leetcode;

public class _151ReverseWordsString {
	
	/*
	 * Given an input string, reverse the string word by word.
	 * 
	 * For example, Given s = "the sky is blue", return "blue is sky the".
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String reverseWords(String s) {
        if(s == null || s.length() == 0) {
            return "";
        }
        String[] strArray = s.split(" ");
        int len = strArray.length;
        StringBuffer sb = new StringBuffer();
        for(int i=len-1; i>=0; i--) {
            if(!strArray[i].equals("")) {
                sb.append(strArray[i]).append(" ");
            }
        }
        if(sb.length() == 0) return "";
        return sb.toString().substring(0, sb.length()-1);
    }

}
