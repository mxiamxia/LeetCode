import java.util.ArrayList;


public class SortListToBST {

	/** 
	 * @author Min
	 * @date Sep 2, 2015
	 * @return void 
	 * @throws 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(0);
		ListNode tmp = head;
		for(int i=1; i<=9; i++) {
			tmp.next = new ListNode(i);
			tmp = tmp.next;
		}
		sortedListToBST(head.next);
	}

	public static TreeNode sortedListToBST(ListNode head) {
		if(head == null)
			return null;
		ListNode cur = head;
		int count = 0;
		while(cur!=null)
		{
			cur = cur.next;
			count++;
		}
		ArrayList<ListNode> list = new ArrayList<ListNode>();
		list.add(head);
		return helper(list,0,count-1);
	}
	private static TreeNode helper(ArrayList<ListNode> list, int l, int r)
	{
		if(l>r)
			return null;
		int m = (l+r)/2;
		TreeNode left = helper(list,l,m-1);
		TreeNode root = new TreeNode(list.get(0).val);
		root.left = left;
		list.set(0,list.get(0).next);
		root.right = helper(list,m+1,r);
		return root;
	}


	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}


	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}


}
