package com.min.backtracking;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class RestoreIP {

	public List<String> restoreIpAddresses(String s) {
		List<String> res = new ArrayList<String>();
		dfs(s, res, "", 0, 0);
		return res;
	}

	private void dfs(String s, List<String> res, String tmp, int index, int dot) {
		if (dot > 3) {
			return;
		}
		if (index == s.length() && dot == 3 && tmp.length() == (s.length() + 3)) {
			res.add(tmp);
			return;
		}
		for (int i = index; i <= s.length(); i++) {
			for (int j = 0; j < 3; j++) {
				if (tmp.equals("")) {
					if ((i + j + 1) <= s.length() && isValid(s.substring(i, i + j + 1))) {
						dfs(s, res, s.substring(i, i + j + 1), i + j + 1, dot);
					}
				} else {
					if ((i + j + 1) <= s.length() && isValid(s.substring(i, i + j + 1))) {
						dfs(s, res, tmp + "." + s.substring(i, i + j + 1), i + j + 1, dot + 1);
					}
				}
			}
		}
	}

	public boolean isValid(String s) {
		if (s.charAt(0) == '0') {
			return "0".equals(s);
		}
		int num = Integer.parseInt(s);
		if (num > 0 && num <= 255) {
			return true;
		} else {
			return false;
		}
	}

}

// class TestCases {
// RestoreIP in = null;
//
// @Before
// private void setup() {
// in = new RestoreIP();
// }
//
//
// @Test
// public void test1() {
// List<String>res = in.restoreIpAddresses("0000");
// }
// }
