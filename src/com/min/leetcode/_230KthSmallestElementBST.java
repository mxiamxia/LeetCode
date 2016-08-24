package com.min.leetcode;

import java.util.ArrayList;
import java.util.List;

import com.min.leetcode._156BinaryTreeUpDown.TreeNode;

public class _230KthSmallestElementBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int kthSmallest(TreeNode root, int k) {
        if (root == null || k < 1) {
            return 0;
        }
        List<Integer> list = new ArrayList<Integer>();
        helper(root, list, k);
        return list.get(k-1);
    }
    private void helper(TreeNode node, List<Integer> list, int k) {
        if (list.size() == k) {
            return;
        }
        if (node == null) {
            return;
        }
        helper(node.left, list, k);
        list.add(node.val);
        helper(node.right, list, k);
    }
}
