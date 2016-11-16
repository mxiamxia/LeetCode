package com.min.binarysearch;

public class ConstructBST {

    private TreeNode root;

    public ConstructBST() {
    }

    /**
     * Will create a BST imperative on order of elements in the array
     */
    public ConstructBST(int[] a) {
        this();
        for (int i : a) {
            add(i);
        }
    }

    private static class TreeNode {
        TreeNode left;
        int item;
        TreeNode right;

        TreeNode(TreeNode left, int item, TreeNode right) {
            this.left = left;
            this.right = right;
            this.item = item; 
        }
    }

    public void add(int item) {
        if (root == null) {
            root = new TreeNode(null, item, null);
            return;
        }

        TreeNode node = root;
        while (true) {
            if (item < node.item) {
                if (node.left == null) {
                    node.left = new TreeNode(null, item, null);
                    break;
                }
                node = node.left;
            } else {
                if (node.right == null) {
                    node.right = new TreeNode(null, item, null);
                    break;
                }
                node = node.right;
            }
        }
    }
}
