public class RotateKList {

	/** 
	 * @author Min
	 * @date Jul 7, 2015
	 * @return void 
	 * @throws 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node = new ListNode(1);
		ListNode head = node;
		for(int i=1;i<2;i++)
		{
			node.next = new ListNode(i);
			node = node.next;
		}
		rotateRight(head, 1);
	}
	
	private static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public static ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0) {
            return head;
        }
        ListNode cycle = head;
        ListNode fast = head;
        ListNode ptr = head;
        ListNode newHead = null;
        int len = 0;
        while(ptr.next != null) {
            len++;
            ptr = ptr.next;
        }
        for(int i=0; i<len+k; i++) {
            fast = fast.next;
            if(i == k) {
                newHead = fast;
            }
            
            if(i == len-1) {
                fast.next = cycle.next;
            }
        }
        fast.next = null;
        return newHead;
    }

}
