package com.min.leetcode;

import java.util.Stack;

public class _84LargestRectangle {
	
	/**
	 * For example,
		Given heights = [2,1,5,6,2,3],
		return 10.
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_84LargestRectangle in = new _84LargestRectangle();
		in.largestRectangleArea(new int[]{2,1,5,6,2,3});
	}
	
	public int largestRectangleArea(int[] height) {
        int len = height.length;
        Stack<Integer> s = new Stack<Integer>();
        int maxArea = 0;
        for(int i = 0; i <= len; i++){
            int h = (i == len ? 0 : height[i]);
            if(s.isEmpty() || h >= height[s.peek()]){
                s.push(i);
            }else{
                int tp = s.pop();
                maxArea = Math.max(maxArea, height[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
                i--;
            }
        }
        return maxArea;
    }

}
