package com.min.leetcode;

public class _222CountCompleteTreeNodes {

	/*
	 * Given a complete binary tree, count the number of nodes.
	 * 
	 * Definition of a complete binary tree from Wikipedia: In a complete binary
	 * tree every level, except possibly the last, is completely filled, and all
	 * nodes in the last level are as far left as possible. It can have between
	 * 1 and 2h nodes inclusive at the last level h.
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int countNodes(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = getLeftHeight(root) + 1;
		int right = getRightHeight(root) + 1;
		if (left == right) {
			return (2 << (left - 1)) - 1;
		} else {
			return countNodes(root.left) + countNodes(root.right) + 1;
		}
	}

	public int getLeftHeight(TreeNode root) {
		int h = 0;
		if (root == null) {
			return h;
		}
		while (root.left != null) {
			h++;
			root = root.left;
		}
		return h;
	}

	public int getRightHeight(TreeNode root) {
		int h = 0;
		if (root == null) {
			return h;
		}
		while (root.right != null) {
			h++;
			root = root.right;
		}
		return h;

	}

}
