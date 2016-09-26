package com.min.leetcode;

import com.min.leetcode._156BinaryTreeUpDown.TreeNode;

// Java program to find largest BST subtree in given Binary Tree

public class _333LargestBST {
	
	/**
	 * Given a Binary Tree, write a function that returns the size of the largest subtree which is also a Binary Search Tree (BST). If the complete Binary Tree is BST, then return the size of whole tree.

Examples:

Input: 
      5
    /  \
   2    4
 /  \
1    3

Output: 3 
	 * 
	 * 
	 * Method 2 (Tricky and Efficient)
In method 1, we traverse the tree in top down manner and do BST test for every node. If we traverse the tree in bottom up manner, then we can pass information about subtrees to the parent. The passed information can be used by the parent to do BST test (for parent node) only in constant time (or O(1) time). A left subtree need to tell the parent whether it is BST or not and also need to pass maximum value in it. So that we can compare the maximum value with the parent’s data to check the BST property. Similarly, the right subtree need to pass the minimum value up the tree. The subtrees need to pass the following information up the tree for the finding the largest BST.
1) Whether the subtree itself is BST or not (In the following code, is_bst_ref is used for this purpose)
2) If the subtree is left subtree of its parent, then maximum value in it. And if it is right subtree then minimum value in it.
3) Size of this subtree if this subtree is BST (In the following code, return value of largestBSTtil() is used for this purpose)

max_ref is used for passing the maximum value up the tree and min_ptr is used for passing minimum value up the tree.
	 * @author min
	 *
	 */

	public class SuperNode {
        int ans;
        int small, large;
        boolean isBST;
        public SuperNode() {
            ans = 0;
            isBST = true;
            small = Integer.MAX_VALUE;
            large = -Integer.MAX_VALUE;
        }
    }
    public int largestBSTSubtree(TreeNode root) {
        return dfs(root).ans;
    }
    public SuperNode dfs(TreeNode node) {
        if (node == null) {
            return new SuperNode();
        }
        SuperNode now = new SuperNode();
        SuperNode left = dfs(node.left);
        SuperNode right = dfs(node.right);
        if (left.small < node.val) {
            now.small = left.small;
        } else {
            now.small = node.val;
        }
        now.large = Math.max(right.large,node.val);
        if (left.isBST && right.isBST && left.large <= node.val && right.small >= node.val) {
            now.ans = left.ans + right.ans +1;
            now.isBST = true;
        } else {
            now.ans=Math.max(left.ans,right.ans);
            now.isBST = false;
        }
        return now;
    }
    
    public static void main(String[] args) {
        /* Let us construct the following Tree
                50
             /      \
            10        60
           /  \       /  \
          5   20    55    70
                   /     /  \
                  45    65    80
         */
 
    	_333LargestBST tree = new _333LargestBST();
    	TreeNode root = new TreeNode(50);
        root.left = new TreeNode(10);
        root.right = new TreeNode(60);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(20);
        root.right.left = new TreeNode(55);
        root.right.left.left = new TreeNode(45);
        root.right.right = new TreeNode(70);
        root.right.right.left = new TreeNode(65);
        root.right.right.right = new TreeNode(80);
 
        /* The complete tree is not BST as 45 is in right subtree of 50.
         The following subtree is the largest BST
             60
            /  \
          55    70
          /     /  \
        45     65   80
        */
        System.out.println("Size of largest BST is " + tree.largestBSTSubtree(root));
    }
}

// This code has been contributed by Mayank Jaiswal
