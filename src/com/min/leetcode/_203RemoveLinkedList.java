package com.min.leetcode;

public class _203RemoveLinkedList {

	/*
	 * Remove all elements from a linked list of integers that have value val.
	 * 
	 * Example Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6 Return: 1
	 * --> 2 --> 3 --> 4 --> 5
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode removeElements(ListNode head, int val) {
		if (head == null) {
			return head;
		}
		ListNode fake = new ListNode(-1);
		fake.next = head;
		ListNode ptr = fake;
		while (ptr.next != null) {
			if (ptr.next.val == val) {
				ptr.next = ptr.next.next;
				continue;
			}
			ptr = ptr.next;
		}
		return fake.next;
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

}
