package com.min.leetcode;

public class _294FlipGameII {

	/*
	 * Problem Description:
	 * 
	 * You are playing the following Flip Game with your friend: Given a string
	 * that contains only these two characters: + and -, you and your friend
	 * take turns to flip two consecutive "++" into "--". The game ends when a
	 * person can no longer make a move and therefore the other person will be
	 * the winner.
	 * 
	 * Write a function to determine if the starting player can guarantee a win.
	 * 
	 * For example, given s = "++++", return true. The starting player can
	 * guarantee a win by flipping the middle "++" to become "+--+".
	 * 
	 * Follow up: Derive your algorithm's runtime complexity.
	 * 
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_294FlipGameII in = new _294FlipGameII();
		in.test();
	}

	public void test() {
        //win ++, +++, ++++, + ++ ++ +++
        //failed,+++++,++--++--
//        String[] testcase = {"+","-","++","--","+++","++++","+--+","-+-+","+++++"};
		String[] testcase = {"+++++"};
        for(int i=0;i<testcase.length;i++){
            System.out.println(firstPlayWinning(testcase[i]));
        }
    }
	
    public boolean firstPlayWinning(String s1) {
        return canWin(s1.toCharArray());
    }
    
    public boolean canWin(char[] cs) {
        for(int i=0;i<cs.length-1;i++) {
            if(cs[i] == cs[i+1] && cs[i]=='+') {
                cs[i] = '-';
                cs[i+1] = '-';
                boolean win = !canWin(cs);
                cs[i] = '+';
                cs[i+1] = '+';
                if(win) return true;
            }
        }
        return false;
    }
}
