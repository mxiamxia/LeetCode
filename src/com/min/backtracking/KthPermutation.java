package com.min.backtracking;

import java.util.ArrayList;
import java.util.List;

public class KthPermutation {
    int nth = 0;
    public String getPermutation(int n, int k) {
        List<String> res = new ArrayList<String>();
        dfs(n, k, res, "", 1);
        return res.get(k-1);
    }
    
    private void dfs(int n, int k, List<String> res, String s, int start) {
        if (s.length() == n) {
            nth++;
            res.add(s);
            return;
        }
        if (nth == k) {
            return;
        }
        for (int i=start; i<=n; i++) {
            dfs(n, k, res, s+i, i+1);
            
        }
    }
    public static void main(String[] args) {
    	KthPermutation in = new KthPermutation();
//    	in.getPermutation(3, 2);
    	System.out.println(Integer.bitCount(7));
    }
}