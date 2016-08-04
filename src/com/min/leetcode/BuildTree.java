package com.min.leetcode;

import java.util.HashMap;

public class BuildTree {

	/** 
	 * @author Min
	 * @date Sep 2, 2015
	 * @return void 
	 * @throws 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] pre = {1,2,4,5,3,6,8,7};
		int[] in = {4,2,5,1,6,8,3,7};
		TreeNode tree = buildTree(pre, in);
	}
	
	public static TreeNode buildTree(int[] preorder, int[] inorder) {
	    if(preorder==null || inorder==null)
	        return null;
	    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	    for(int i=0;i<inorder.length;i++)
	    {
	        map.put(inorder[i],i);
	    }
	    return helper(preorder,0,preorder.length-1,inorder,0,inorder.length-1, map);
	}
	private static TreeNode helper(int[] preorder, int preL, int preR, int[] inorder, int inL, int inR, HashMap<Integer, Integer> map)
	{
	    if(preL>preR || inL>inR)
	        return null;
	    TreeNode root = new TreeNode(preorder[preL]);
	    int index = map.get(root.val);
	    root.left = helper(preorder, preL+1, index-inL+preL, inorder, inL, index-1, map);
	    root.right = helper(preorder, preL+index-inL+1, preR, inorder, index+1, inR,map);
	    return root;
	}
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

}
