package com.min.leetcode;

public class _148SortList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public ListNode sortList(ListNode head) {
        if(head == null|| head.next == null)
            return head;
        ListNode slow = head, fast = head, firsthalf = head;
        while(fast.next!=null&&fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondhalf = slow.next;
        slow.next = null;
        
        ListNode leftlist = null, rightlist =null;
        if(firsthalf!=secondhalf){
            leftlist = sortList(firsthalf);
            rightlist = sortList(secondhalf);
        }
        return mergeTwoLists(leftlist, rightlist);
    }
    
    public ListNode mergeTwoLists(ListNode leftlist, ListNode rightlist){
        if(rightlist == null)
            return leftlist;
        if(leftlist == null)
            return rightlist;
        
        ListNode fakehead = new ListNode(-1);
        ListNode ptr = fakehead;
        while(rightlist!=null&&leftlist!=null){
            if(rightlist.val<leftlist.val){
                ptr.next = rightlist;
                ptr = ptr.next;
                rightlist = rightlist.next;
            }else{
                ptr.next = leftlist;
                ptr = ptr.next;
                leftlist = leftlist.next;
            }
        }
        
        if(rightlist!=null)
            ptr.next = rightlist;
        if(leftlist!=null)
            ptr.next = leftlist;
        
        return fakehead.next;
    }
    static class ListNode {
    	int val;
    	ListNode next;
    	public ListNode(int val) {
    		this.val = val;
    	}
    }

}
