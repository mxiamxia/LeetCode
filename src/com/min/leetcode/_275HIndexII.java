package com.min.leetcode;

public class _275HIndexII {

	/*
	 * Follow up for H-Index: What if the citations array is sorted in ascending
	 * order? Could you optimize your algorithm?
	 * 
	 * 
	 * 复杂度 时间 O(logN) 空间 O(1)
	 * 
	 * 思路 在升序的引用数数组中，假设数组长为N，下标为i，则N -
	 * i就是引用次数大于等于下标为i的文献所对应的引用次数的文章数。如果该位置的引用数小于文章数，则说明则是有效的H指数，如果一个数是H指数，
	 * 那最大的H指数一定在它的后面（因为是升序的）。根据这点就可已进行二分搜索了。这里min = mid + 1的条件是citations[mid] <
	 * n - mid，确保退出循环时min肯定是指向一个有效的H指数。
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        int min = 0, max = citations.length-1;
        int len = citations.length;
        while (min <= max) {
            int mid = (min + max) / 2;
            if (citations[mid] < len - mid) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        return len - min;
    }

}
