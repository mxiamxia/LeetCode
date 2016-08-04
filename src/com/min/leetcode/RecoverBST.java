
public class RecoverBST {

	static TreeNode pre = null;
	static TreeNode s1 = null;
	static TreeNode s2 = null;
	/** 
	 * @author Min
	 * @date Sep 9, 2015
	 * @return void 
	 * @throws 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(5);
		TreeNode r1 = new TreeNode(3);
		TreeNode r2 = new TreeNode(4);
		root.right = r1;
		r1.right = r2;
		recoverTree(root);
	}

	
	public static void recoverTree(TreeNode root) {
		inorder(root);
		if(s1!=null && s2!=null) {
			int tmp = s1.val;
			s1.val = s2.val;
			s2.val = tmp;
		}
	}
	public static void inorder(TreeNode root) {
		if(root == null) {
			return;
		}
		inorder(root.left);
		if(pre == null) {
			pre = root;
		}
		else {
			if(pre.val > root.val) {
				if(s1 == null) {
					s1 = pre;
				}
				s2 = root;
			}
			pre = root;
		}
		inorder(root.right);
	}
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}


}



