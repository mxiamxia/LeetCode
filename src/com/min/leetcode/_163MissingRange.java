package com.min.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _163MissingRange {
	
	/**
	 * Given a sorted integer array where the range of elements are [lower, upper] inclusive, return its missing ranges.

		For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2", "4->49", "51->74", "76->99"].
		
		
		1）针对一些特殊情况，询问面试官，比如说如果array是个空的，或者array包含区间内的所有元素，相应的返回值是什么
		2）可以给出一些有意思的test case，另外就是不需要限制给出的范围是[0, 99]，用start和end表示就行。
		在面试的时候可以先提一下，写出[0, 99]的代码，然后在稍作修改，变成start和end的版本。
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public List<String> findMissingRanges1(int[] vals, int start, int end) {
		List<String> res = new ArrayList<String>();
		int pre = start-1;
		int cur = 0;
		for (int i=0; i<=vals.length; i++) {
			if (i == vals.length) {
				cur = end+1;
			} else {
				cur = vals[i];
			}
			if ((cur - pre) > 1) {
				String range = getRange(pre+1, end-1);
				res.add(range);
			}
			pre = cur;
		}
		return res;
	}
	
	public List<String> findMissingRanges(int[] vals, int start, int end) {
		List<String> res = new ArrayList<String>();
		int pre = start - 1;
		int curr = 0;
		for(int i=0; i<=vals.length; i++) {
			if (i == vals.length) {
				curr = end + 1;
			} else {
				curr = vals[i];
			}
			if ((curr-pre) >= 2) {
				res.add(getRange(pre+1, curr-1));
			}
			pre = curr;
		}
		return res;
	}

	private String getRange(int i, int j) {
		// TODO Auto-generated method stub
		return (i==j) ? String.valueOf(i) : i + "->" + j;
	}

}
