package com.min.linkedlist;

public class AddTwoNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next = new ListNode(3);
		
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next = new ListNode(4);
		AddTwoNumber in = new AddTwoNumber();
		in.addTwoNumbers(l1, l2);
	}
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode res = head;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int val = l1.val + l2.val + carry;
            carry = 0;
            if (val <= 9 ) {
                res.next = new ListNode(val);
                res = res.next;
            } else {
                carry = 1;
                int v = val % 10;
                res.next = new ListNode(v);
                res = res.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 != null) {
            res = l1;
        }
        if (l2 != null) {
            res = l2;
        }
        return head.next;
    }
	
	public static class ListNode {
		public int val;
		public ListNode next;

		public ListNode(int x) {
			this.val = x;
		}
	}

}
