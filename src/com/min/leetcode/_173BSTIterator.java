package com.min.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _173BSTIterator {
	/*
	 * Implement an iterator over a binary search tree (BST). Your iterator will
	 * be initialized with the root node of a BST.
	 * 
	 * Calling next() will return the next smallest number in the BST.
	 * 
	 * Note: next() and hasNext() should run in average O(1) time and uses O(h)
	 * memory, where h is the height of the tree.
	 * 
	 * In order traversal bst and save node into list in order
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	List<TreeNode> list = new ArrayList<TreeNode>();

	public _173BSTIterator(TreeNode root) {
        inOrder(root);
    }

	public void inOrder(TreeNode node) {
		if (node == null) {
			return;
		}
		inOrder(node.left);
		list.add(node);
		inOrder(node.right);
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		if (list.size() > 0) {
			return true;
		} else {
			return false;
		}
	}

	/** @return the next smallest number */
	public int next() {
		return list.remove(0).val;
	}
	
	
	// Solution 2
	public class BSTIterator {
		Stack<TreeNode> stack;
	 
		public BSTIterator(TreeNode root) {
			stack = new Stack<TreeNode>();
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
		}
	 
		public boolean hasNext() {
			return !stack.isEmpty();
		}
	 
		public int next() {
			TreeNode node = stack.pop();
			int result = node.val;
			if (node.right != null) {
				node = node.right;
				while (node != null) {
					stack.push(node);
					node = node.left;
				}
			}
			return result;
		}
	}

}
