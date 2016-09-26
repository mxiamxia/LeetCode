package com.min.leetcode;

import com.min.leetcode._156BinaryTreeUpDown.TreeNode;

public class _337HourseRobberIII {

	/*
	 * The thief has found himself a new place for his thievery again. There is
	 * only one entrance to this area, called the "root." Besides the root, each
	 * house has one and only one parent house. After a tour, the smart thief
	 * realized that "all houses in this place forms a binary tree". It will
	 * automatically contact the police if two directly-linked houses were
	 * broken into on the same night.
	 * 
	 * Determine the maximum amount of money the thief can rob tonight without
	 * alerting the police.
	 * 
	 * Example 1: 3 / \ 2 3 \ \ 3 1 Maximum amount of money the thief can rob =
	 * 3 + 3 + 1 = 7.
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_337HourseRobberIII tree = new _337HourseRobberIII();
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(2);
		root.left.right = new TreeNode(3);
		root.right = new TreeNode(3);
		root.right.right = new TreeNode(1);
		System.out.println(tree.rob(root));
	}

	public int rob(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int val = 0;
		if (root.left != null) {
			val += rob(root.left.left) + rob(root.left.right);
		}
		if (root.right != null) {
			val += rob(root.right.left) + rob(root.right.right);
		}
		return Math.max(root.val + val, rob(root.left) + rob(root.right));
	}

	/*
	 * 显然有：
	 * 
	 * rob_root = max(rob_L + rob_R , no_rob_L + no_nob_R + root.val)
	 * no_rob_root = rob_L + rob_R
	 */
	public int robDp(TreeNode root) {
		return dfs(root)[0];
	}

	private int[] dfs(TreeNode root) {
		int dp[] = { 0, 0 };
		if (root != null) {
			int[] dp_L = dfs(root.left);
			int[] dp_R = dfs(root.right);
			dp[1] = dp_L[0] + dp_R[0];
			dp[0] = Math.max(dp[1], dp_L[1] + dp_R[1] + root.val);
		}
		return dp;
	}

}
