package com.min.leetcode;

public class _456132Pattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_456132Pattern in = new _456132Pattern();
		in.find132pattern(new int[]{-2,1,2,-2,1,2});
	}
	
	public boolean find132pattern(int[] nums) {
        if(nums.length<3) return false;
        Integer low = null, high = null;
        int start = 0, end = 0;
        while(start<nums.length-1){
            while(start<nums.length-1 && nums[start]>=nums[start+1]) start++;
            // start is lowest now
            int m = start+1;
            while(m<nums.length-1 && nums[m]<=nums[m+1]) m++;
            // m is highest now
            int j = m+1;
            while(j<nums.length){
                if(nums[j]>nums[start] && nums[j]<nums[m]) return true;
                j++;
            }
            start = m+1;
        }
        return false;
    }

}
