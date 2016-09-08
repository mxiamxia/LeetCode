package com.min.leetcode;

import java.util.Iterator;
import java.util.List;

public class _251Flatten2DVec {
	/*
	 * Implement an iterator to flatten a 2d vector.
	 * 
	 * For example, Given 2d vector =
	 * 
	 * [ [1,2], [3], [4,5,6] ] By calling next repeatedly until hasNext returns
	 * false, the order of elements returned by next should be: [1,2,3,4,5,6].
	 * 
	 * 
	 * 复杂度 时间 O(N) 空间 O(1)
	 * 
	 * 思路
	 * 维护两个迭代器：一个是输入的List<List<Integer>>的迭代器，它负责遍历List<Integer>的迭代器。另一个则是List<
	 * Integer>的迭代器，它负责记录当前到哪一个List的迭代器了。每次next时，我们先调用一下hasNext，
	 * 确保当前List的迭代器有下一个值。
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	Iterator<List<Integer>> it;
    Iterator<Integer> curr;
	
	public _251Flatten2DVec(List<List<Integer>> vec2d) {
		it = vec2d.iterator();
	}
	
	public int next() {
		if (hasNext()) {
			return curr.next();
		} else {
			return Integer.MAX_VALUE;
		}
		
	}
	
	public boolean hasNext() {
		if (curr == null || (!curr.hasNext() && it.hasNext())) {
			curr = it.next().iterator();
		}
		return curr.hasNext();
	}

}
