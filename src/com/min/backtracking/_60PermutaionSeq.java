package com.min.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _60PermutaionSeq {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_60PermutaionSeq in = new _60PermutaionSeq();
		in.getPermutation(2, 2);
	}
	
	public String getPermutation(int n, int k) {
        List<String> res = new ArrayList<String>();
        boolean[] visit = new boolean[n];
        dfs(n, k, visit, res, "");
        return res.get(k-1);
    }
    
    private void dfs(int n, int k, boolean[] visit, List<String> res, String s) {
        if (s.length() == n) {
            k--;
            res.add(new String(s));
            Arrays.fill(visit, false);
            return;
        }
        if (k <= 0) {
            return;
        }
        for (int i=1; i<=n; i++) {
            if (!visit[i-1]) {
                visit[i-1] = true;
                dfs(n, k, visit, res, s+i);
            }
        }
    }

}
