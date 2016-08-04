package com.min.leetcode;

public class _374GuessNumberI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int guessNumber(int n) {
		int low = 1;
		int high = n;

		while (low <= high) {
			int mid = low + ((high - low) / 2);
			int result = guess(mid);
			if (result == 0) {
				return mid;
			} else if (result == 1) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}

		return -1;
	}
}
