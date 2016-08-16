package com.min.leetcode;

public class _186_ReverseWordsStringII {

	/*
	 * Given an input string, reverse the string word by word. A word is defined
	 * as a sequence of non-space characters.
	 * 
	 * The input string does not contain leading or trailing spaces and the
	 * words are always separated by a single space.
	 * 
	 * For example, Given s = "the sky is blue", return "blue is sky the".
	 * 
	 * Could you do it in-place without allocating extra space?
	 * 
	 * Solution:
	 * Reverse each word in the original string, then reverse the whole string
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	public void reverseWords(char[] s) {
		if (s.length <= 1) {
			return;
		}
	    int i=0;
	    //reverse each word in the string
	    for(int j=0; j<s.length; j++){
	        if(s[j]==' '){
	            reverse(s, i, j-1);        
	            i=j+1;
	        }
	    }
	 //reverse the last word
	    reverse(s, i, s.length-1);
	 // reverse the whole string
	    reverse(s, 0, s.length-1);
	}
	 
	public void reverse(char[] s, int i, int j){
	    while(i<j){
	        char temp = s[i];
	        s[i]=s[j];
	        s[j]=temp;
	        i++;
	        j--;
	    }
	}
	
	
}
