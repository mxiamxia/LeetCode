package com.min.leetcode;


public class DistinctSubs {

	/** 
	 * @author Min
	 * @date Sep 3, 2015
	 * @return void 
	 * @throws 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numDistinct("rabbbit", "rabbit"));
	}

	public static int numDistinct(String S, String T) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (S.length() == 0) {
			return T.length() == 0 ? 1 : 0;
		}
		if (T.length() == 0) {
			return 1;
		}
		int cnt = 0;
		for (int i = 0; i < S.length(); i++) {
			if (S.charAt(i) == T.charAt(0)) {
				cnt += numDistinct(S.substring(i + 1), T.substring(1));
			}
		}
		return cnt;
	}


}
