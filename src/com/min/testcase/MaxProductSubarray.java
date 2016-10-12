package com.min.testcase;

import static org.junit.Assert.*;

import org.junit.Test;

import com.min.leetcode._152MaxProductSubarray;


public class MaxProductSubarray {
	_152MaxProductSubarray test = new _152MaxProductSubarray();
	
	@Test
	public void testSortList1() {
		int[] t1 = new int[]{2,3,-2,4}; 
		int expect = test.maxProduct(t1);
		assertEquals(expect, 6);
 	}
	
	
	@Test
	public void testSortList2() {
		int[] t1 = new int[]{0}; 
		int expect = test.maxProduct(t1);
		assertEquals(expect, 1);
 	}

}
