package com.min.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _199BinaryTreeRightView {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.right = new TreeNode(4);
		rightSideView(root);
	}

	static int maxDep = 0;
	//DFS version
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        helper(root, res, 1);
        return res;
    }
    private static void helper(TreeNode node, List<Integer> list, int dep) {
        if (dep > maxDep) { // the same level only add the right tree
            maxDep = dep;
            list.add(node.val);
        }
        if (node.right != null) {
            helper(node.right, list, dep+1);
        }
        if (node.left != null) {
            helper(node.left, list, dep+1);
        }
    }

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	//Queue version
	public List<Integer> rightSideView2(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(queue.size() > 0) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                TreeNode node = queue.remove();
                if (i==0) {
                    res.add(node.val);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
                if(node.left != null) {
                    queue.add(node.left);
                }
            }
        }
        return res;
     }
}
