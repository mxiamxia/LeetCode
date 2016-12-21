package com.min.leetcode;

public class _297SerializeBT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_297SerializeBT in = new _297SerializeBT();
		TreeNode root = new TreeNode(1);
		in.serialize(root);
	}

	public String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		serializeHelper(root, sb);
		return sb.toString();
	}

	private void serializeHelper(TreeNode root, StringBuilder sb) {
		// base case
		if (root == null) {
			sb.append("N").append(",");
			return;
		}
		// pre-order traversal.
		sb.append(root.val);
		sb.append(",");
		serializeHelper(root.left, sb);
		serializeHelper(root.right, sb);
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		String[] splitInfo = data.split(",");
		int[] index = new int[] { 0 };
		return deserializeHelper(splitInfo, index);
	}

	private TreeNode deserializeHelper(String[] splitInfo, int[] index) {
		// base case
		if (index[0] == splitInfo.length || splitInfo[index[0]].equals("N")) {
			return null;
		}
		TreeNode curRoot = new TreeNode(Integer.parseInt(splitInfo[index[0]]));
		index[0]++;
		curRoot.left = deserializeHelper(splitInfo, index);
		index[0]++;
		curRoot.right = deserializeHelper(splitInfo, index);
		return curRoot;
	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

}
