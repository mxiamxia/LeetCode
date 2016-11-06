package com.min.hackerrank;

import java.util.ArrayList;
import java.util.List;

public class gl_array_game {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		gl_array_game in = new gl_array_game();
		in.getReachableNums(new int[]{4, 6});
	}
	
	public Iterable<Integer> getReachableNums(int[] arr){
        List<Integer> res = new ArrayList<Integer>();
        assert(arr.length == 2);

        int gcd = gcd1(arr[0], arr[1]);
        int max = Math.max(arr[0], arr[1]);
        for (int i = 1; i*gcd <= max; i++){
            res.add(i*gcd);
        }

        return res;
    }
	
	private int gcd1(int x, int y) {
		if (y == 0) {
			return x;
		}
		return gcd1(y, x%y);
	}

    private int gcd(int a, int b){
        if (a * b == 0){
            return 1;
        } else if (a == b){
            return a;
        } else {
            a = (a < b) ? a : a + b;
            b = (b > a) ? b : a - b;
            a = (a > b) ? a - b : a;
            return gcd(a, b - a);
        }
    }

}
