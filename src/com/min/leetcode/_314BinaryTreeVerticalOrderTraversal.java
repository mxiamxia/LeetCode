package com.min.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.min.leetcode._156BinaryTreeUpDown.TreeNode;

public class _314BinaryTreeVerticalOrderTraversal {

	
	/*
	 * Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).

		If two nodes are in the same row and column, the order should be from left to right.
		
		Examples:
		Given binary tree [3,9,20,null,null,15,7],
		
		    3
		   / \
		  9  20
		    /  \
		   15   7
		 
		
		return its vertical order traversal as:
		
		[
		  [9],
		  [3,15],
		  [20],
		  [7]
		]
		
		题解：

		二叉树Vertical order traversal。这道题意思很简单但例子举得不够好，
		假如上面第二个例子里5还有右子树的话，就会和20在一条column里。
		总的来说就是假定一个node的column是 i，那么它的左子树column就是i - 1，
		右子树column就是i + 1。我们可以用decorator模式建立一个TreeColumnNode，
		包含一个TreeNode，以及一个column value，然后用level order traversal进行计算就可以了，
		计算的时候用一个HashMap保存column value以及相同value的点。
		也要设置一个min column value和一个max column value，
		方便最后按照从小到大顺序获取hashmap里的值输出。这道题Discuss区Yavinci大神写得非常棒，放在reference里。
		
		Time Complexity - O(n)，  Space Complexity - O(n)
		
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	int min = Integer.MAX_VALUE;
	int max = Integer.MIN_VALUE;
	public List<List<Integer>> verticalOrder(TreeNode root) {   
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		if (root == null) {
			return res;
		}
		dfs(root, 0, map);
		for (int i=min; i<max; i++) {
			if (map.containsKey(i)) {
				res.add(map.get(i));
			}
		}
		return res;
	}

	private void dfs(TreeNode root, int i, Map<Integer, List<Integer>> map) {
		// TODO Auto-generated method stub
		if (root == null) {
			return;
		}
		min = Math.min(min, i);
		max = Math.max(max, i);
		if (map.containsKey(i)) {
			map.get(i).add(root.val);
		} else {
			List<Integer> list = new ArrayList<Integer>();
			list.add(root.val);
			map.put(i, list);
		}
		dfs(root.left, i-1, map);
		dfs(root.right, i+1, map);
	}
	
	

}
