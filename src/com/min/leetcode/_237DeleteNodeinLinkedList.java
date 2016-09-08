package com.min.leetcode;

import com.min.leetcode._148SortList.ListNode;

public class _237DeleteNodeinLinkedList {

	/*
	 * Write a function to delete a node (except the tail) in a singly linked
	 * list, given only access to that node.
	 * 
	 * Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third
	 * node with value 3, the linked list should become 1 -> 2 -> 4 after
	 * calling your function.
	 * 
	 * 
	 * 把当前节点被下一个节点覆盖
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void deleteNode(ListNode node) {
		node.val = node.next.val;
		node.next = node.next.next;
		return;
	}

}
