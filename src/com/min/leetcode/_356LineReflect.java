package com.min.leetcode;

import java.util.HashSet;
import java.util.Set;

public class _356LineReflect {
	/*
	 * Given n points on a 2D plane, find if there is such a line parallel to
	 * y-axis that reflect the given set of points.
	 * 
	 * Example 1: Given points = [[1,1],[-1,1]], return true.
	 * 
	 * Example 2: Given points = [[1,1],[-1,-1]], return false.
	 * 
	 * 这道题给了我们一堆点，问我们存不存在一条平行于y轴的直线，使得所有的点关于该直线对称。题目中的提示给的相当充分，
	 * 我们只要按照提示的步骤来做就可以解题了。首先我们找到所有点的横坐标的最大值和最小值，那么二者的平均值就是中间直线的横坐标，然后我们遍历每个点，
	 * 如果都能找到直线对称的另一个点，则返回true，反之返回false，参见代码如下：
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isReflected(int[][] points) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        Set<String> set = new HashSet<String>();
        for (int[] p : points) {
            set.add(p[0] + "," + p[1]);
            min = Math.min(min, p[0]);
            max = Math.max(max, p[0]);
        }
        
        int sum = min + max;
        for (int[] p : points) {
            if (!set.contains((sum - p[0]) + "," + p[1])) {
                return false;
            }
        }
        return true;
    }
}
