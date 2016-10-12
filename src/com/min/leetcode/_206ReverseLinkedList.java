package com.min.leetcode;

import java.util.Stack;

import com.min.leetcode._203RemoveLinkedList.ListNode;

public class _206ReverseLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode reverseList(ListNode head) {
		if (head == null) {
			return head;
		}
		Stack<ListNode> st = new Stack<ListNode>();
		while (head != null) {
			st.push(head);
			head = head.next;
		}
		ListNode fake = new ListNode(-1);
		ListNode ptr = fake;
		while (st.size() > 0) {
			ptr.next = st.pop();
			ptr = ptr.next;
		}
		ptr.next = null;
		return fake.next;
	}

	public ListNode reverseList2(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode p1 = head;
		ListNode p2 = p1.next;

		head.next = null;
		while (p1 != null && p2 != null) {
			ListNode t = p2.next;
			p2.next = p1;
			p1 = p2;
			p2 = t;
		}

		return p1;
	}

	public class ListNode {
		public int val;
		public ListNode next;

		public ListNode(int x) {
			val = x;
		}
	}

}
