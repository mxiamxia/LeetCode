package com.min.leetcode;

import com.min.leetcode._156BinaryTreeUpDown.TreeNode;
import java.util.HashMap;
import java.util.Map;

public class _236LowestCommonAncestorBinaryTree {

	/*
	 * 我们可以用深度优先搜索，从叶子节点向上，标记子树中出现目标节点的情况。如果子树中有目标节点，标记为那个目标节点，如果没有，标记为null。显然，
	 * 如果左子树、右子树都有标记，说明就已经找到最小公共祖先了。如果在根节点为p的左右子树中找p、q的公共祖先，则必定是p本身。
	 * 
	 * 换个角度，可以这么想：如果一个节点左子树有两个目标节点中的一个，右子树没有，那这个节点肯定不是最小公共祖先。
	 * 如果一个节点右子树有两个目标节点中的一个，左子树没有，那这个节点肯定也不是最小公共祖先。只有一个节点正好左子树有，右子树也有的时候，
	 * 才是最小公共祖先。
	 */

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		// 发现目标节点则通过返回值标记该子树发现了某个目标结点
		if (root == null || root == p || root == q)
			return root;
		// 查看左子树中是否有目标结点，没有为null
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		// 查看右子树是否有目标节点，没有为null
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		// 都不为空，说明做右子树都有目标结点，则公共祖先就是本身
		if (left != null && right != null)
			return root;
		// 如果发现了目标节点，则继续向上标记为该目标节点
		return left == null ? right : left;
	}
	
	// Java program to find lowest common ancestor using parent pointer
	// A tree node
	class Node 
	{
	    int key;
	    Node left, right, parent;
	 
	    Node(int key) 
	    {
	        this.key = key;
	        left = right = parent = null;
	    }
	}
	 
	class BinaryTree 
	{
	    Node root, n1, n2, lca;
	 
	    /* A utility function to insert a new node with
	       given key in Binary Search Tree */
	    Node insert(Node node, int key) 
	    {
	        /* If the tree is empty, return a new node */
	        if (node == null)
	            return new Node(key);
	 
	        /* Otherwise, recur down the tree */
	        if (key < node.key) 
	        {
	            node.left = insert(node.left, key);
	            node.left.parent = node;
	        }
	        else if (key > node.key) 
	        {
	            node.right = insert(node.right, key);
	            node.right.parent = node;
	        }
	 
	        /* return the (unchanged) node pointer */
	        return node;
	    }
	 
	    // To find LCA of nodes n1 and n2 in Binary Tree
	    Node LCA(Node n1, Node n2) 
	    {
	        // Creata a map to store ancestors of n1
	        Map<Node, Boolean> ancestors = new HashMap<Node, Boolean>();
	 
	        // Insert n1 and all its ancestors in map
	        while (n1 != null) 
	        {
	            ancestors.put(n2, Boolean.TRUE);
	            n1 = n1.parent;
	        }
	 
	        // Check if n2 or any of its ancestors is in
	        // map.
	        while (n2 != null) 
	        {
	            if (ancestors.containsKey(n2) != ancestors.isEmpty())
	                return n2;
	            n2 = n2.parent;
	        }
	 
	        return null;
	    }
	 
	    // Driver method to test above functions
	    
	}
	public static void main(String[] args) 
    {
		_236LowestCommonAncestorBinaryTree x = new _236LowestCommonAncestorBinaryTree();
        BinaryTree tree = x.new BinaryTree();
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 8);
        tree.root = tree.insert(tree.root, 22);
        tree.root = tree.insert(tree.root, 4);
        tree.root = tree.insert(tree.root, 12);
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 14);
 
        tree.n1 = tree.root.left.right.left;
        tree.n2 = tree.root.left;
        tree.lca = tree.LCA(tree.n1, tree.n2);
 
        System.out.println("LCA of " + tree.n1.key + " and " + tree.n2.key
                + " is " + tree.lca.key);
    }

}
