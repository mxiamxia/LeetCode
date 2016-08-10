package com.min.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class _158ReadNCharsII {
	
	/**
	 * The API: int read4(char *buf) reads 4 characters at a time from a file.

			The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.
			
			By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.
			
			Note: The read function may be called multiple times.
			Input:    "ab", [read(1),read(2)]
			Output:    ["a",""]
			Expected:    ["a","b"]
			
			if n < 4, we have to save the current reading for next read
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static Queue<Character> queue = new LinkedList<Character> ();
	public static int read(char[] buf, int n) {
		int i = 0;
		while (i<n && !queue.isEmpty()) {
			char tmp = queue.poll();
			i++;
		}
		char[] temp = new char[4];
		for (; i<n; i+=4) {
			int len = read4(temp);
			if(len > (n-i)) {
				System.arraycopy(temp, 0, buf, i, n-i);
				for(int j=n-i; j<4; j++) {
					queue.add(temp[j]);
				}
			} else {
				System.arraycopy(temp, 0, buf, i, len);
			}
			return i+len;
		}
		return n;
	}

}
