package com.min.leetcode;

import java.util.HashMap;
import java.util.Map;

public class _447NumOfBoom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_447NumOfBoom in = new _447NumOfBoom();
		in.numberOfBoomerangs(new int[][]{{0,0},{1,0},{2,0}});
		
	}
	
	public int numberOfBoomerangs(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        Map<Double, Integer> map = new HashMap<Double, Integer>();
        int count = 0;
        for (int i=0; i<points.length; i++) {
            for (int j=0; j<points.length; j++) {
                double dist = distance(points[i], points[j]);
                if (map.containsKey(dist)) {
                    int value = map.get(dist);
                    count += 2 * value;
                    map.put(dist, value+1);
                } else {
                    map.put(dist, 1);
                }
            }
        }
        return count;
    }
    private double distance(int[] a, int[] b) {
        return Math.sqrt(Math.pow(a[0] - b[0], 2) + Math.pow(a[1] - b[1], 2));
    }

}
