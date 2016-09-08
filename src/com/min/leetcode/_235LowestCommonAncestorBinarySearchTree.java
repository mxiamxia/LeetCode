package com.min.leetcode;

import com.min.leetcode._156BinaryTreeUpDown.TreeNode;

public class _235LowestCommonAncestorBinarySearchTree {
	
	/*
	 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

        _______6______
       /              \
    ___2__          ___8__
   /      \        /      \
   0      _4       7       9
         /  \
         3   5
For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. Another example is LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
	 */
	
	/*
	 * 使用递归可以轻松解决此问题。对于此题我们可以分为三种情况讨论：

		1. P, Q都比root小，则LCA在左树，我们继续在左树中寻找LCA
		
		2. P, Q都比root大，则LCA在右树，我们继续在右树中寻找LCA
		
		3. 其它情况，表示P,Q在root两边，或者二者其一是root，或者都是root，这些情况表示root就是LCA，直接返回root即可。
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        
        return root;
    }

}
