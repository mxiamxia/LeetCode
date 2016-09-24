package com.min.hackerrank;

public class LongestSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[] {4, 3, 1, 2, 1};
		System.out.println(maxLength(a, 4));

	}
	static int maxLength(int[] a, int k) {
        if (a == null || a.length == 0) {
            return 0;
        }
        int result = 0;
        for (int i=0; i<a.length; i++) {
            int len = 0;
            int sum = 0;
            for(int j=i; j<a.length; j++) {
                sum += a[j];
                if (sum > k) {
                    result = Math.max(result, len);
                    break;
                }
                len++;
                result = Math.max(result, len);
            }
        }
        return result;
    }

}
