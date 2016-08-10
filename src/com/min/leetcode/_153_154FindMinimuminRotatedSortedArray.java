package com.min.leetcode;

public class _153_154FindMinimuminRotatedSortedArray {
	/**
	 * 和Search in Rotated Sorted Array I这题换汤不换药。同样可以根据A[mid]和A[end]来判断右半数组是否sorted：
		原数组：0 1 2 4 5 6 7
		情况1：  6 7 0 1 2 4 5   
		情况2：  2 4 5 6 7 0 1  
		(1) A[mid] < A[end]：A[mid : end] sorted => min不在A[mid+1 : end]中
		搜索A[start : mid]
		(2) A[mid] > A[end]：A[start : mid] sorted且又因为该情况下A[end]<A[start] => min不在A[start : mid]中
		搜索A[mid+1 : end]
		(3) base case：
		a. start =  end，必然A[start]为min，为搜寻结束条件。
		b. start + 1 = end，此时A[mid] =  A[start]，而min = min(A[mid], A[end])。而这个条件可以合并到(1)和(2)中。
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int findMin(int[] num) {
        int start = 0, end = num.length-1;
        while(start<end) {
            int mid = start+(end-start)/2;
            if(num[mid]<num[end]) 
                end = mid;
            else 
                start = mid+1;
        }
        return num[start];
    }
	
	
	/**
	 * 思路：Find Minimum in Rotated Sorted Array II

		和Search in Rotated Sorted Array II这题换汤不换药。同样当A[mid] = A[end]时，无法判断min究竟在左边还是右边。
		
		3 1 2 3 3 3 3 
		3 3 3 3 1 2 3
		
		但可以肯定的是可以排除A[end]：因为即使min = A[end]，由于A[end] = A[mid]，排除A[end]并没有让min丢失。所以增加的条件是：
		
		A[mid] = A[end]：搜索A[start : end-1]
	 */
	
	public int findMinII(int[] nums) {
		int low = 0, high = nums.length-1;
        while(low < high) {
            int mid = low + (high-low)/2;
            if (nums[mid] < nums[high]) {
                high = mid;
            } else if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                high--;
            }
        }
        return nums[low];
	}

}
