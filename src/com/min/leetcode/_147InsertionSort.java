package com.min.leetcode;


public class _147InsertionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(5);
		head.next = new ListNode(6);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		insertionSortList(head);
	}
	
	public static ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fake = new ListNode(0);
        // fake.next = head;
        ListNode cur = head;
        while (cur != null) {
            ListNode pre = fake;
            while (pre.next != null && pre.next.val < cur.val) {
                pre = pre.next;
            }
            ListNode next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = next;
        }
        return fake.next;
    }
	
	static class ListNode {
    	int val;
    	ListNode next;
    	public ListNode(int val) {
    		this.val = val;
    	}
    }

}
