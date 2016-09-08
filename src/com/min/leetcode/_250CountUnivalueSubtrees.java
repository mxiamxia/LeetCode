package com.min.leetcode;

public class _250CountUnivalueSubtrees {
	/*
	 * Given a binary tree, count the number of uni-value subtrees.
	 * 
	 * A Uni-value subtree means all nodes of the subtree have the same value.
	 * 
	 * For example: Given binary tree, 
	 *               5
		             / \
		            1   5
		           / \   \
		          5   5   5
	 * 是求节点值都一样的所有子树个数，上面例子中元素都是5的子树有3个叶节点，和根节点的右子树。

如果有是子树，就必须有叶子节点，所以应该从叶子节点往上判断，但是节点没有父节点，无法往上判断，所以可以采用递归的方法从上往下调用判断。

以上面为例子：

计数器count初始为0

根节点为5，且有左右子树，所以分别判断左右子树是不是元素值都为5的子树个数count，如果是则count++，如果不是分别统计左子树的元素值一样的个数和右子树元素值一样的子树个数。
	 */
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_250CountUnivalueSubtrees in = new _250CountUnivalueSubtrees();
		in.countUnivalSubtrees(root);
	}
	private int count = 0;
	public int countUnivalSubtrees(TreeNode root) {
		unival(root);
		return count;
	}

	private boolean unival(TreeNode root) {
		// TODO Auto-generated method stub
		if (root == null) {
			return true;
		}
		if (root.left == null && root.right == null) {
			count++;
			return true;
		}
		boolean left = unival(root.left);
		boolean right = unival(root.right);
		if (left && right && (root.left == null || root.left.val == root.val) && (root.right == null || root.right.val == root.val)) {
			count++;
			return true;
		}
		return false;
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

}
