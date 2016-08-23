package com.min.leetcode;

public class _226InvertBinaryTree {
	/*
	 * Invert a binary tree.

		     4
		   /   \
		  2     7
		 / \   / \
		1   3 6   9
		to
		     4
		   /   \
		  7     2
		 / \   / \
		9   6 3   1
			 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

}
