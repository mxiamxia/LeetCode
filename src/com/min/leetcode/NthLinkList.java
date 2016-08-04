
public class NthLinkList {

	
	
	
	/** 
	 * @author Min
	 * @date May 19, 2015
	 * @return void 
	 * @throws 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new NthLinkList().test();
	}
	
	public void test()
	{
		ListNode node = new ListNode(1);
		ListNode head = node;
		for(int i=2;i<5;i++)
		{
			node.next = new ListNode(i);
			node = node.next;
		}
		
		removeNthFromEnd(head, 2);
		
	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode cur = head, prev = head;
		while(n-- > 0) {
			cur = cur.next;
		}
		if (cur == null) 
			return head.next;
		while (cur.next != null) {
			cur = cur.next;
			prev = prev.next;
		}
		prev.next = prev.next.next;
		return head;
	}

	private class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { 
			val = x; 
		}
	}

}
