package com.min.leetcode;

public class _303RangeSumQuery {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	int[] sum;
    public _303RangeSumQuery(int[] nums) {
        if (nums.length == 0) {
            sum = nums;
        } else {
            sum = new int[nums.length];
            sum[0] = nums[0];
            for (int i=1; i<nums.length; i++) {
                sum[i] = sum[i-1] + nums[i];
            }
        }
    }

    public int sumRange(int i, int j) {
        if (sum.length == 0) {
            return 0;
        }
        if (i == 0) {
            return sum[j];
        } else {
            return sum[j] - sum[i-1];
        }
    }

}
