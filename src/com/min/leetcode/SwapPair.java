

public class SwapPair {

	/** 
	 * @author Min
	 * @date May 29, 2015
	 * @return void 
	 * @throws 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SwapPair().test();
	}


	private void test() {
		// TODO Auto-generated method stub
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(3);
		node.next.next.next = new ListNode(4);
//		swapPairs(node);
		reverseKGroup(node,3);
	}


	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}

	public ListNode swapPairs(ListNode head) {
		if(head == null || head.next == null)
			return head;

		ListNode fakehead = new ListNode(-1);
		fakehead.next = head;

		ListNode ptr1 = fakehead;
		ListNode ptr2 = head;

		while(ptr2!=null && ptr2.next!=null){
			ListNode nextstart = ptr2.next.next;
			ptr2.next.next = ptr2;
			ptr1.next = ptr2.next;
			ptr2.next = nextstart;
			ptr1 = ptr2;
			ptr2 = ptr2.next;
		}
		return fakehead.next;
	}
	
	
	public ListNode reverseKGroup(ListNode head, int k) {
	    if(head == null)
	    {
	        return null;
	    }
	    ListNode dummy = new ListNode(0);
	    dummy.next = head;
	    int count = 0;
	    ListNode pre = dummy;
	    ListNode cur = head;
	    while(cur != null)
	    {
	        count ++;
	        ListNode next = cur.next;
	        if(count == k)
	        {
	            pre = reverse(pre, next);
	            count = 0;   
	        }
	        cur = next;
	    }
	    return dummy.next;
	}
	private ListNode reverse(ListNode pre, ListNode end)
	{
	    if(pre==null || pre.next==null)
	        return pre;
	    ListNode head = pre.next;
	    ListNode cur = pre.next.next;
	    while(cur!=end)
	    {
	        ListNode next = cur.next;
	        cur.next = pre.next;
	        pre.next = cur;
	        cur = next;
	    }
	    head.next = end;
	    return head;
	}
}
