package com.min.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _366FindLeavesofBinaryTree {
	
	/**
	 * Given a binary tree, collect a tree's nodes as if you were doing this: Collect and remove all leaves, repeat until the tree is empty.

	Example:
	Given binary tree

          1
         / \
        2   3
       / \     
      4   5    
	Returns [4, 5, 3], [2], [1].
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<List<Integer>> findLeaves(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		dfs(res, root);
		return res;
	}

	private int dfs(List<List<Integer>> res, TreeNode root) {
		// TODO Auto-generated method stub
		if (root == null) {
			return -1;
		}
		int left = dfs(res, root.left);
		int right = dfs(res, root.right);
		int curr = Math.max(left, right)+1;
		
		if (res.size() <= curr) {
			res.add(new ArrayList<Integer>());
		}
		res.get(curr).add(root.val);
		
		return curr;
	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
