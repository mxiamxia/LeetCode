package com.min.leetcode;

import com.min.leetcode._156BinaryTreeUpDown.TreeNode;

public class _298BinaryTreeLongestConsecutiveSequence {
	/*
	 * Given a binary tree, find the length of the longest consecutive sequence path.

		The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The longest consecutive path need to be from parent to child (cannot be the reverse).
		
		For example,
		
		   1
		    \
		     3
		    / \
		   2   4
		        \
		         5 
		Longest consecutive sequence path is 3-4-5, so return 3.
		
		   2
		    \
		     3
		    / 
		   2    
		  / 
		 1 
	 * 
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int longestConsecutive(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return findLongest(root, root.val-1, 0);
	}

	private int findLongest(TreeNode root, int len, int preVal) {
		// TODO Auto-generated method stub
		if (root == null) {
			return len;
		}
		len = root.val == preVal+1 ? len+1 : 1;
		return Math.max(len, Math.max(findLongest(root.left, len, root.val), findLongest(root.right, len, root.val)));
	}

}
