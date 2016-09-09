package com.min.leetcode;

import java.util.ArrayList;
import java.util.List;

import com.min.leetcode._156BinaryTreeUpDown.TreeNode;

public class _257BinaryTreePaths {
	/*
	 * Given a binary tree, return all root-to-leaf paths.

		For example, given the following binary tree:
		
		   1
		 /   \
		2     3
		 \
  		  5
	All root-to-leaf paths are:
	
	["1->2->5", "1->3"]
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 public List<String> binaryTreePaths(TreeNode root) {
		 List<String> res = new ArrayList<String>();
		 if (root == null) {
			 return res;
		 }
		 helper(root, res, String.valueOf(root.val));
		 return res;
	 }
	private void helper(TreeNode root, List<String> res, String val) {
		// TODO Auto-generated method stub
		if (root.left ==null && root.right == null) {
			res.add(val);
			return;
		}
		if (root.left != null) {
			helper(root.left, res, val + "->" + root.left);
		}
		if (root.right != null) {
			helper(root.right, res, val+ "->" + root.right);
		}
	}
}
