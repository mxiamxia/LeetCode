package com.min.leetcode;

public class _160InsectionOfTwoLinkedList {
	
	/**
	 * 题目大意：给两个链表，找出它们交集的那个节点，要求时间复杂度O(n)，空间复杂度O(1)。

		有以下几种思路：
		（1）暴力破解，遍历链表A的所有节点，并且对于每个节点，都与链表B中的所有节点比较，退出条件是在B中找到第一个相等的节点。时间复杂度O(lengthA*lengthB)，空间复杂度O(1)。
		
		（2）哈希表。遍历链表A，并且将节点存储到哈希表中。接着遍历链表B，对于B中的每个节点，查找哈希表，如果在哈希表中找到了，说明是交集开始的那个节点。时间复杂度O(lengthA+lengthB)，空间复杂度O(lengthA)或O(lengthB)。
		
		（3）双指针法，指针pa、pb分别指向链表A和B的首节点。
		遍历链表A，记录其长度lengthA，遍历链表B，记录其长度lengthB。
		因为两个链表的长度可能不相同，比如题目所给的case，lengthA=5，lengthB=6，则作差得到lengthB-lengthA=1，将指针pb从链表B的首节点开始走1步，即指向了第二个节点，pa指向链表A首节点，然后它们同时走，每次都走一步，当它们相等时，就是交集的节点。
		时间复杂度O(lengthA+lengthB)，空间复杂度O(1)。双指针法的代码如下：
	 * 
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 1;
		int j = 2;
		
		ListNode A = new ListNode(1);
		A.next = new ListNode(2);
		A.next.next = new ListNode(3);
		A.next.next.next = new ListNode(8);
		ListNode B = new ListNode(4);
		B.next = new ListNode(5);
		B.next.next = new ListNode(8);
		getIntersectionNode(A, B);

	}
	
	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int lenA = getLen(headA);
        int lenB = getLen(headB);
        int diff = lenA - lenB;
        if (lenA > lenB) {
            diff = lenA - lenB;
            while (diff > 0) {
                headA = headA.next;
                diff--;
            }
        } else {
            diff = lenB - lenA;
            while (diff > 0) {
                headB = headB.next;
                diff--;
            }
        }
        while(headA != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
    private static int getLen(ListNode node) {
        int i = 0;
        while (node != null) {
            node = node.next;
            i++;
        }
        return i;
    }
	
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int val) {
			this.val = val;
			this.next = null;
		}
	}

}
