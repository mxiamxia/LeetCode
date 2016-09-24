package com.min.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _293FlipGame {

	/*
	 * You are playing the following Flip Game with your friend: Given a string
	 * that contains only these two characters: + and -, you and your friend
	 * take turns to flip two consecutive "++" into "--". The game ends when a
	 * person can no longer make a move and therefore the other person will be
	 * the winner.
	 * 
	 * Write a function to compute all possible states of the string after one
	 * valid move.
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<String> generatePossibleNextMoves(String s) {
		List<String> list = new ArrayList<String>();
		if (s == null) {
			return list;
		}
		char[] strArray = s.toCharArray();
		for (int i=0; i<strArray.length-1; i++) {
			if (strArray[i] == strArray[i+1] && strArray[i] == '+') {
				strArray[i] = '-';
				strArray[i+1] = '-';
				list.add(String.valueOf(strArray));
				strArray[i] = '+';
				strArray[i+1] = '+';
			}
		}
		return list;
	}
}
