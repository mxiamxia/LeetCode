package com.min.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _288UniqueWordAbbreviation {
	List<String> list;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public _288UniqueWordAbbreviation(String[] dictionary) {
		list = new ArrayList<String>();
		for (String word : dictionary) {
			list.add(abbConvert(word));
		}
		
	}
	public boolean isUnique(String word) {  
		return !list.contains(abbConvert(word));
	}
	
	public String abbConvert(String word) {
		int len = word.length();
		String ret = String.valueOf(word.charAt(0)) + (len-2) + String.valueOf(word.charAt(len-1));
		return ret;
	}

}
