import java.util.ArrayList;
import java.util.Arrays;


public class Subsets {

	/** 
	 * @author Min
	 * @date Jul 22, 2015
	 * @return void 
	 * @throws 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {1,2,3};
		subsets(input);
	}
	public static ArrayList<ArrayList<Integer>> subsets(int[] S) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> tmp = new ArrayList<Integer>();
		Arrays.sort(S);
		res.add(tmp);
		dfs(res,tmp,S,0);
		return res;
	}

	public static void dfs(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> tmp, int[] S, int pos){
		for(int i=pos; i<=S.length-1;i++){
			tmp.add(S[i]);
			res.add(new ArrayList<Integer>(tmp));
			dfs(res,tmp,S,i+1);
			tmp.remove(tmp.size()-1);
		}
	}
}
