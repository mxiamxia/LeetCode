package com.min.leetcode;

public class _245ShortestWordDistIII {

	/*
	 * This is a follow up of Shortest Word Distance. The only difference is now
	 * word1 could be the same as word2.
	 * 
	 * Given a list of words and two words word1 and word2, return the shortest
	 * distance between these two words in the list.
	 * 
	 * word1 and word2 may be the same and they represent two individual words
	 * in the list.
	 * 
	 * For example, Assume that words = ["practice", "makes", "perfect",
	 * "coding", "makes"].
	 * 
	 * Given word1 = “makes”, word2 = “coding”, return 1. Given word1 = "makes",
	 * word2 = "makes", return 3.
	 * 
	 * Note: You may assume word1 and word2 are both in the list.
	 * 
	 * 时间 O(N) 空间 O(N)
	 * 
	 * 这题和I是一样的，唯一不同的是对于word1和word2相同的时候，我们要区分第一次遇到和第二次遇到这个词。这里加入了一个turns，
	 * 如果是相同单词的话，每次遇到一个单词turn加1，这样可以根据turn来判断是否要switch。
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] list = new String[] {"practice", "makes", "perfect", "coding", "makes"};
		shortestWordDistance(list, "makes", "makes");
	}

	public int shortestWordDistanceMap(String[] words, String word1, String word2) {

		return 0;
	}
	
	public static int shortestWordDistance(String[] words, String word1, String word2) {
        int idx1 = -1, idx2 = -1, distance = Integer.MAX_VALUE, turn = 0, inc = (word1.equals(word2) ? 1 : 0);
        for(int i = 0; i < words.length; i++){
            if(words[i].equals(word1) && turn % 2 == 0){  // use turn % 2 to have two words go to diff branch each time
                idx1 = i;
                if(idx2 != -1) distance = Math.min(distance, idx1 - idx2);
                turn += inc;
            } else if(words[i].equals(word2)){
                idx2 = i;
                if(idx1 != -1) distance = Math.min(distance, idx2 - idx1);
                turn += inc;
            }
        }
        return distance;
    }

}
