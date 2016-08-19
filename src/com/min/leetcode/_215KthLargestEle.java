package com.min.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class _215KthLargestEle {
	/*
	 * Find the kth largest element in an unsorted array. Note that it is the
	 * kth largest element in the sorted order, not the kth distinct element.
	 * 
	 * For example, given [3,2,1,5,6,4] and k = 2, return 5.
	 * 
	 * Note: You may assume k is always valid, 1 ≤ k ≤ array's length.
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// findKthLargest(new int[] { 3, 2, 1, 5, 6, 4 }, 2);
	}

	public static int findKthLargest1(int[] nums, int k) {
		PriorityQueue<Integer> q = new PriorityQueue<Integer>(k);
		for (int i : nums) {
			q.offer(i);

			if (q.size() > k) {  // delete the small eles and only keep the last K large eles
				q.poll();
			}
		}

		return q.peek();
	}

	public int findKthLargest2(int[] nums, int k) {
		if (k > nums.length) {
			return -1;
		}
		Arrays.sort(nums);
		return nums[nums.length - k];
	}

	public int findKthLargest(int[] nums, int k) {
		if (k < 1 || nums == null) {
			return 0;
		}

		return getKth(nums.length - k, nums, 0, nums.length - 1);
	}

	public int getKth(int k, int[] nums, int start, int end) {

		int pivot = nums[end];

		int left = start;
		int right = end;

		while (true) {

			while (nums[left] < pivot && left < right) {
				left++;
			}

			while (nums[right] >= pivot && right > left) {
				right--;
			}

			if (left == right) {
				break;
			}

			swap(nums, left, right);
		}

		swap(nums, left, end);

		if (k == left) {
			return pivot;
		} else if (k < left) {
			return getKth(k, nums, start, left - 1);
		} else {
			return getKth(k, nums, left + 1, end);
		}
	}

	public void swap(int[] nums, int n1, int n2) {
		int tmp = nums[n1];
		nums[n1] = nums[n2];
		nums[n2] = tmp;
	}

}
