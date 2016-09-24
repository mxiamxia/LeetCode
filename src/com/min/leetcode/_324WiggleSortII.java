package com.min.leetcode;

public class _324WiggleSortII {
	
	/*
	 * 
	 * Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....

Example:
(1) Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4, 1, 5, 1, 6]. 
(2) Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2, 3, 1, 3, 1, 2].
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int[] temp = new int[nums.length];
        int s = (nums.length + 1) >> 1, t = nums.length;
        for (int i = 0; i < nums.length; i++) {
            temp[i] = (i & 1) == 0 ?  nums[--s] : nums[--t] ;
        }
 
        for (int i = 0; i < nums.length; i++)
            nums[i] = temp[i];
    }

}
