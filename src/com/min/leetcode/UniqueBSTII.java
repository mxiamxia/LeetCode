import java.util.ArrayList;


public class UniqueBSTII {

	/** 
	 * @author Min
	 * @date Aug 31, 2015
	 * @return void 
	 * @throws 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(generateTrees(0));
		int[] a = {1, 2};
		test(a);
		System.out.println(a[0] + a[1]);
	}

	private static void test(int[] a) {
		// TODO Auto-generated method stub
		a[0] = 9;
		a[1] = 8;
	}

	public static ArrayList<TreeNode> generateTrees(int n) {
		return generateTrees(1, n);//从1作为root开始，到n作为root结束
	}

	private static ArrayList<TreeNode> generateTrees(int left, int right){
		ArrayList<TreeNode> res = new ArrayList<TreeNode>();
		if (left > right){
			res.add(null);
			return res;
		}
		for (int i = left; i <= right; i++){
			ArrayList<TreeNode> lefts = generateTrees(left, i-1);//以i作为根节点，左子树由[1,i-1]构成
			ArrayList<TreeNode> rights = generateTrees(i+1, right);//右子树由[i+1, n]构成
			for (int j = 0; j < lefts.size(); j++) {
				for (int k = 0; k < rights.size(); k++) {
					TreeNode root = new TreeNode(i);
					root.left = lefts.get(j);
					root.right = rights.get(k);
					res.add(root);//存储所有可能行
				}
			}
		}
		return res;
	}


	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}


}
