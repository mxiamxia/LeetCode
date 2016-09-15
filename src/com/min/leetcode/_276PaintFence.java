package com.min.leetcode;

public class _276PaintFence {
	
	/*
	 * There is a fence with n posts, each post can be painted with one of the k colors.

		You have to paint all the posts such that no more than two adjacent fence posts have the same color.
		
		Return the total number of ways you can paint the fence.
		
		Note: n and k are non-negative integers.
		
		
		题解：
		设S(n)表示当前杆和前一个杆颜色相同的个数，D(n)表示当前杆和前一个颜色不相同的个数。
		
		则递推关系式为：
		
		S(n) = D(n - 1)， 即若当前杆和前一个杆颜色相同的个数等于前一个杆和再前一个杆颜色不相同的个数。
		
		D(n) = (k - 1) * (D(n - 1) + S(n - 1))，即前一个杆和再前一个杆所有可能的颜色组合，乘以当前杆与前一个杆颜色不相同的个数，即（k - 1）。
		
		用两个变量记录D和S，并交替更新即可。
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_276PaintFence in = new _276PaintFence();
		System.out.println(in.numWays(2, 3));
		System.out.println(in.numWays1(2, 3));
	}

	public int numWays(int n, int k) {
		return (int) (Math.pow(k-1, n-1) * k);
	}
	
	public int numWays1(int n, int k) {  
        if(n == 0 || k == 0)  
            return 0;  
        if(n == 1)  
            return k;  
        // n = 2;
        int lastS = k;  
        int lastD = k * (k - 1);  
        for(int i = 2; i < n; i++) {  
            int tempD = (k - 1) * (lastS + lastD);  
            lastS = lastD;  
            lastD = tempD;  
        }  
        return lastS + lastD;  
    }  
}

