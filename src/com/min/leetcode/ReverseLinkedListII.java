public class ReverseLinkedListII {

	/** 
	 * @author Min
	 * @date Aug 26, 2015
	 * @return void 
	 * @throws 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node = new ListNode(1);
		ListNode head = node;
		for(int i=2;i<7;i++)
		{
			node.next = new ListNode(i);
			node = node.next;
		}
		reverseBetween(head, 2, 5);
	}
	
	private static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	
	public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode newhead = new ListNode(-1);
        newhead.next = head;
        
        if(head==null||head.next==null)
            return newhead.next;
            
        ListNode startpoint = newhead;//startpoint指向需要开始reverse的前一个
        ListNode node1 = null;//需要reverse到后面去的节点
        ListNode node2 = null;//需要reverse到前面去的节点
        
        for (int i = 0; i < n; i++) {
            if (i < m-1){
                startpoint = startpoint.next;//找真正的startpoint
            } else if (i == m-1) {//开始第一轮
                node1 = startpoint.next;
                node2 = node1.next;
            }else {
                node1.next = node2.next;//node1交换到node2的后面
                node2.next = startpoint.next;//node2交换到最开始
                startpoint.next = node2;//node2作为新的点
                node2 = node1.next;//node2回归到node1的下一个，继续遍历
            }
        }
        return newhead.next;
    }

}
