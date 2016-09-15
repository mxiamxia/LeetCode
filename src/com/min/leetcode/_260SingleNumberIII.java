package com.min.leetcode;

public class _260SingleNumberIII {

	/*
	 * Given an array of numbers nums, in which exactly two elements appear only
	 * once and all the other elements appear exactly twice. Find the two
	 * elements that appear only once.
	 * 
	 * For example:
	 * 
	 * Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
	 * 
	 * 
	 * 题解
	 * 
	 * 题 Single Number 的 follow up, 不妨设最后两个只出现一次的数分别为 x1, x2.
	 * 那么遍历数组时根据两两异或的方法可得最后的结果为 x1 ^ x2, 如果我们要分别求得 x1 和 x2, 我们可以根据 x1 ^ x2 ^ x1
	 * = x2 求得 x2, 同理可得 x_1.
	 * 那么问题来了，如何得到x1和x2呢？看起来似乎是个死循环。大多数人一般也就能想到这一步(比如我...)。
	 * 
	 * 这道题的巧妙之处在于利用x1 ^ x2的结果对原数组进行了分组，进而将x1和x2分开了。具体方法则是利用了x1 ^ x2不为0的特性，如果x1 ^
	 * x2不为0，那么x1 ^
	 * x2的结果必然存在某一二进制位不为0（即为1），我们不妨将最低位的1提取出来，由于在这一二进制位上x1和x2必然相异，即x1,
	 * x2中相应位一个为0，另一个为1，所以我们可以利用这个最低位的1将x1和x2分开。又由于除了x1和x2之外其他数都是成对出现，
	 * 故与最低位的1异或时一定会抵消，十分之精妙！
	 * 
	 * 源码分析
	 * 
	 * 求一个数二进制位1的最低位方法为 x1xorx2 - (x1xorx2 & (x1xorx2 - 1)), 其他位运算的总结可参考 Bit
	 * Manipulation。利用last1Bit可将数组的数分为两组，一组是相应位为0，另一组是相应位为1.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] singleNumber(int[] nums) {
		int[] res = new int[2];
		if (nums == null || nums.length == 0) {
			return null;
		}
		int x1xorx2 = 0;
		for (int i : nums) {
			x1xorx2 ^= i;
		}
		int lastDigitOne = x1xorx2 - (x1xorx2 & (x1xorx2 - 1));
		int x1 = 0, x2 = 0;
		for (int i : nums) {
			if ((lastDigitOne & i) == 0) {
				x1 ^= i;
			} else {
				x2 ^= i;
			}
		}
		res[0] = x1;
		res[1] = x2;
		return res;
	}

}
