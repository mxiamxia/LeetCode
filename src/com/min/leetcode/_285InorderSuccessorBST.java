package com.min.leetcode;

import com.min.leetcode._156BinaryTreeUpDown.TreeNode;

public class _285InorderSuccessorBST {

	/*
	 * Given a binary search tree and a node in it, find the in-order successor
	 * of that node in the BST.
	 * 
	 * Traversal: 
	 * we start from the root, each time we see a node with val
	 * larger than p -> val, we know this node may be p's successor. So we
	 * record it in suc. Then we try to move to the next level of the tree: if p
	 * -> val > root -> val, which means p is in the right subtree, then its
	 * successor is also in the right subtree, so we update root = root ->
	 * right; if p -> val < root -> val, we update root = root -> left
	 * similarly; once we find p -> val == root -> val, we know we've reached at
	 * p and the current sucis just its successor.
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		TreeNode suc = null;
		while (root != null && root.val != p.val) {
			if (root.val > p.val) {
				root = root.left;
				suc = root;
			} else {
				root = root.right;
			}
		}
		if (root == null) {
			return null;
		}
		if (root.right == null) {
			return null;
		}
		root = root.right;
		while (root.left != null) {
			root = root.left;
		}
		return root;
	}

}
