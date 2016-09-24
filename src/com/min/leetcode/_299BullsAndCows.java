package com.min.leetcode;

public class _299BullsAndCows {

	/*
	 * You are playing the following Bulls and Cows game with your friend: You write a 4-digit secret number and ask your friend to guess it, each time your friend guesses a number, you give a hint, the hint tells your friend how many digits are in the correct positions (called "bulls") and how many digits are in the wrong positions (called "cows"), your friend will use those hints to find out the secret number.

			For example:
			
			Secret number:  1807
			Friend's guess: 7810
			Hint: 1 bull and 3 cows. (The bull is 8, the cows are 0, 1 and 7.)
	 * 
	 * 我们其实可以用一次循环就搞定的，在处理不是bulls的位置时，我们看如果secret当前位置数字的映射值小于0，则表示其在guess中出现过，
	 * cows自增1，然后映射值加1，如果guess当前位置的数字的映射值大于0，则表示其在secret中出现过，cows自增1，然后映射值减1，
	 * 参见代码如下：
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String getHint(String secret, String guess) {
		if (secret == null || guess == null) {
			return "";
		}
		int[] map = new int[256];
		int bulls = 0;
		int cows = 0;
		for (int i = 0; i < secret.length(); i++) {
			if (secret.charAt(i) == guess.charAt(i)) {
				bulls++;
			} else {
				if (map[secret.charAt(i)]++ < 0) {
					cows++;
				}
				if (map[guess.charAt(i)]-- > 0) {
					cows++;
				}
			}
		}
		return bulls + "A" + cows + "B";
	}

}
