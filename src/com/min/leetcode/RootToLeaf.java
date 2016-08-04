import java.util.ArrayList;
import java.util.List;


public class RootToLeaf {

	/** 
	 * @author Min
	 * @date Sep 15, 2015
	 * @return void 
	 * @throws 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node = new TreeNode(0);
		node.left= new TreeNode(1);
		System.out.println(sumNumbers(node));
	}


	public static int sumNumbers(TreeNode root) {
		if(root == null) {
			return 0;
		}
		List<Integer> list = new ArrayList<Integer>();
		int[] sum = new int[2];
		sum[0] = 0;
		sum[1] = 0;
		dfs(root, list, sum);
		return sum[0];
	}
	public static void dfs(TreeNode root, List<Integer> list, int[] sum) {
		if(root == null) {
			int len = list.size();
			if(len > 0 && sum[1] == 1) {
				int path = 0;
				for(int i=len; i>0; i--) {
					path += list.get(len-i) * Math.pow(10, i-1);
				}
				sum[0] += path;
				list.remove(list.size()-1);
				sum[1] = 0;
			}
			return;
		}
		list.add(root.val);
		sum[1] = 1;
		dfs(root.left, list, sum);
		dfs(root.right, list, sum);
		return;
	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

}
