package com.min.leetcode;

import java.util.HashSet;
import java.util.Set;

public class _202HappyNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<Integer>();
        while(n != 1) {
            int t = 0;
            while (n != 0) {
                t += (n % 10) * (n % 10);
                n = n / 10;
            }
            n = t;
            if (t == 1) {
                break;
            }
            if (set.contains(t)) {
                break;
            } else {
                set.add(t);
            }
        }
        return n == 1;
    }
}
