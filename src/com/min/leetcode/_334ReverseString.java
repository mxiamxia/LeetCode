package com.min.leetcode;

public class _334ReverseString {
	
	/*
	 * Write a function that takes a string as input and returns the string reversed.

Example:
Given s = "hello", return "olleh".
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String reverseString(String s) {
        if (s == null) {
            return null;
        }
        if (s == "") {
            return "";
        }
        char[] array = s.toCharArray();
        for (int i=0, j=array.length-1; i<j; i++,j--) {
            char tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
        }
        return new String(array);
    }

}
