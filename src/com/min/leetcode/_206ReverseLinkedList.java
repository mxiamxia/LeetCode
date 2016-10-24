package com.min.leetcode;

import java.util.Stack;

import com.min.leetcode._203RemoveLinkedList.ListNode;

public class _206ReverseLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_206ReverseLinkedList in = new _206ReverseLinkedList();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		in.reverseList2(head);
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

	public static class ListNode {
		public int val;
		public ListNode next;

		public ListNode(int x) {
			val = x;
		}
	}

}
