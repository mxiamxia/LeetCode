package com.min.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _368LargestDivset {

	/**
	 * 
	 * Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies: Si % Sj = 0 or Sj % Si = 0.

			If there are multiple solutions, return any subset is fine.
			
			Example 1:
			
			nums: [1,2,3]
			
			Result: [1,2] (of course, [1,3] will also be ok)
			Example 2:
			
			nums: [1,2,4,8]
			
			Result: [1,2,4,8]
	 * 这道题基本考察的是DP的应用，首先对nums进行排序，对第i个元素，
	 * 我们考虑这个元素是最大元素的subset，所以我们每次检查之前的i-1个元素，
	 * 在第i个元素能整除的元素中，找到那个对应集合最大的，假设为j，因为第j个元素能整除第i个元素，
	 * 所以j对应的集合中的所有元素也能整除第i个元素。这样我们就找到了第i个元素对应的集合，把i指向j，
	 * 并记录subset的size（应该是j元素对应的subset的size加1）。
	 * 所以需要创建一个n*2的array来保存临时数据，第一列是指针，指向之前的某一个元素；
	 * 第二列是以此元素为最大元素的subset的size。
	 * 最后，只要我们控制一个全局的变量来记录和更新最大的subset的大小和最后一个元素的index就可以像linked list一样把最大subset中的所有元素全部找到了。时间是O(n^2)，空间是O(n)。
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,4,8};
		List<Integer> res = largestDivisibleSubset(nums);
		System.out.println(res.toString());
	}

	public static List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        int globalSize = 0;
        int idx = 0;
        int[][] count = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            count[i][0] = -1;
            count[i][1] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && count[j][1] + 1 > count[i][1]) {
                    count[i][0] = j;
                    count[i][1] = count[j][1] + 1;
                }
            }
            if (count[i][1] > globalSize) {
                globalSize = count[i][1];
                idx = i;
            }
        }
        while (idx != -1) {
            res.add(nums[idx]);
            idx = count[idx][0];
        }
        return res;
    }
}

