package com.min.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class _179LargestNum {

	/*
	 * Given a list of non negative integers, arrange them such that they form
	 * the largest number.
	 * 
	 * For example, given [3, 30, 34, 5, 9], the largest formed number is
	 * 9534330.
	 * 
	 * Note: The result may be very large, so you need to return a string
	 * instead of an integer.
	 * 
	 * 
	 * 从第一位向后比较，如果有一位更大，则该数更大，如9大于15，24大于23。
	 * 如果某个数的前半部分和另一个数完全相同，则看该数剩下的那部分和另一个数的大小关系，如2332和23比较时，2332是大于23的，因为32大于23。
	 * 不过如果细分各种情况，会弄得非常复杂，这里有个技巧，就是我们把两个数拼在一起，然后再把这两个数换个顺序再拼在一起，这时候就可以直接比较了。
	 * 比如2332和23，变成233223和232332两个数，这时候那个数更大，就说明这个数前半部分的那个数是更大的，这里是2332。
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String largestNumber(int[] nums) {
		if (nums == null || nums.length == 0) {
			return null;
		}
		Integer[] ints = new Integer[nums.length];
		// 将其放入Integer数组方便排序
		for (int i = 0; i < nums.length; i++) {
			ints[i] = nums[i];
		}
		Arrays.sort(ints, new Comparator<Integer>() {
			public int compare(Integer num1, Integer num2) {
				String str1 = String.valueOf(num1);
				String str2 = String.valueOf(num2);
				return (str2 + str1).compareTo(str1 + str2);
			}
		});
		// 如果第一个数是0，则直接返回0
		if (ints[0] == 0) {
			return "0";
		}
		StringBuilder sb = new StringBuilder();
		for (Integer n : ints) {
			sb.append(n);
		}
		return sb.toString();
	}
}
