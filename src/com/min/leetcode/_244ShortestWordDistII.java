package com.min.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _244ShortestWordDistII {

	/*
	 * This is a follow up of Shortest Word Distance. The only difference is now
	 * you are given the list of words and your method will be called repeatedly
	 * many times with different parameters. How would you optimize it?
	 * 
	 * Design a class which receives a list of words in the constructor, and
	 * implements a method that takes two words word1 and word2 and return the
	 * shortest distance between these two words in the list.
	 * 
	 * For example, Assume that words = ["practice", "makes", "perfect",
	 * "coding", "makes"].
	 * 
	 * Given word1 = “coding”, word2 = “practice”, return 3. Given word1 =
	 * "makes", word2 = "coding", return 1.
	 * 
	 * Note: You may assume that word1 does not equal to word2, and word1 and
	 * word2 are both in the list.
	 * 
	 * 
	 * 
	 * 复杂度 时间 O(N) 空间 O(N)
	 * 
	 * 思路 因为会多次调用，我们不能每次调用的时候再把这两个单词的下标找出来。我们可以用一个哈希表，在传入字符串数组时，就把每个单词的下标找出存入表中。
	 * 这样当调用最短距离的方法时，我们只要遍历两个单词的下标列表就行了。具体的比较方法，则类似merge two
	 * list，每次比较两个list最小的两个值，得到一个差值。然后把较小的那个给去掉。因为我们遍历输入数组时是从前往后的，所以下标列表也是有序的。
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	HashMap<String, List<Integer>> map = new HashMap<String, List<Integer>>();

	public _244ShortestWordDistII(String[] words) {
		// 统计每个单词出现的下标存入哈希表中
		for (int i = 0; i < words.length; i++) {
			List<Integer> cnt = map.get(words[i]);
			if (cnt == null) {
				cnt = new ArrayList<Integer>();
			}
			cnt.add(i);
			map.put(words[i], cnt);
		}
	}

	public int shortest(String word1, String word2) {
		List<Integer> idx1 = map.get(word1);
		List<Integer> idx2 = map.get(word2);
		int distance = Integer.MAX_VALUE;
		int i = 0, j = 0;
		// 每次比较两个下标列表最小的下标，然后把跳过较小的那个
		while (i < idx1.size() && j < idx2.size()) {
			distance = Math.min(Math.abs(idx1.get(i) - idx2.get(j)), distance);
			if (idx1.get(i) < idx2.get(j)) {
				i++;
			} else {
				j++;
			}
		}
		return distance;
	}

}
