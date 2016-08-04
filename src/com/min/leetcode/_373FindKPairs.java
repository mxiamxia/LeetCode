package com.min.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class _373FindKPairs {
/**
	You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.

	Define a pair (u,v) which consists of one element from the first array and one element from the second array.

	Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.

	Example 1:
	Given nums1 = [1,7,11], nums2 = [2,4,6],  k = 3

	Return: [1,2],[1,4],[1,6]

	The first 3 pairs are returned from the sequence:
	[1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Arrays.toString(kSmallestPairs(new int[]{1,7,11}, new int[]{2,4,6}, 3).toArray()));
	}

	public static ArrayList<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		ArrayList<int[]> res = new ArrayList<int[]>();
		boolean visit[][] = new boolean[nums1.length][nums2.length];

		Queue<int[]> heap = new PriorityQueue<int[]>(new Comparator<int[]>() {
			public int compare(int[] i, int[] j) {
				return (nums1[i[0]] + nums2[i[1]] - (nums1[j[0]] + nums2[j[1]]));
			}
		});

		heap.add(new int[] { 0, 0 });
		visit[0][0] = true;

		while (!heap.isEmpty() && res.size() < k) {
			int d[] = heap.poll();
			res.add(new int[] { nums1[d[0]], nums2[d[1]] });

			if (d[1] + 1 < nums2.length && visit[d[0]][d[1] + 1] == false) {
				heap.add(new int[] { d[0], d[1] + 1 });
				visit[d[0]][d[1] + 1] = true;
			}
			if (d[0] + 1 < nums1.length && visit[d[0] + 1][d[1]] == false) {
				heap.add(new int[] { d[0] + 1, d[1] });
				visit[d[0] + 1][d[1]] = true;
			}
		}
		return res;
	}

}
