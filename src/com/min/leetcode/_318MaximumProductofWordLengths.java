package com.min.leetcode;

public class _318MaximumProductofWordLengths {
	
	/*
	 * 
	 * 
	 * 
	 * Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. You may assume that each word will contain only lower case letters. If no such two words exist, return 0.

Example 1:
Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
Return 16
The two words can be "abcw", "xtfn".

Example 2:
Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"]
Return 4
The two words can be "ab", "cd".

Example 3:
Given ["a", "aa", "aaa", "aaaa"]
Return 0
No such pair of words.


其实因为全部都是小写的字母，用int 就可以存储每一位的信息。这就是位运算

elements[i] |= 1 << (words[i][j] – ‘a’);   //把words[i][j] 在26字母中的出现的次序变为1
 elements[i] & elements[j]    // 判断是否有交集只需要两个数 按位 与 （AND）运算即可
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	public int maxProduct(String[] words) {
        int res = 0;
        if (words == null || words.length == 0) {
            return res;
        }
        int len = words.length;
        int[] flag = new int[len];
        for (int i=0; i<len; i++) {
            for (int j=0; j<words[i].length(); j++) {
                char c = words[i].charAt(j);
                flag[i] |= 1 << (c-'a');
            }
        }
        for (int i=0; i<len; i++) {
            for (int j=i+1; j<len; j++) {
                if ((flag[i] & flag[j]) == 0) {
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }
        return res;
    }
}
