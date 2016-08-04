import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SubsetII {

	/** 
	 * @author Min
	 * @date Aug 25, 2015
	 * @return void 
	 * @throws 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {1, 2};
		System.out.println(subsetsWithDup(input));
		System.out.println(subsets(input));
	}


    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0) {
            return result;
        }
        List<Integer> tmp = new ArrayList<Integer>();
        Arrays.sort(nums);
        dfs(nums, 0, tmp, result);
        return result;
    }
    
    public static ArrayList<ArrayList<Integer>> subsets(int[] num) {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	if(num == null || num.length ==0) {
    		return result;
    	}
    	Arrays.sort(num);
    	subsetsHelper(result, list, num, 0);
    	
    	return result;
    }
    public static void dfs(int[] nums, int start, List<Integer> tmp, List<List<Integer>> result) {
        result.add(new ArrayList<Integer>(tmp));
        for(int i=start; i<nums.length; i++) {
            if(i!=start && nums[i]==nums[i-1]) {
            	continue;
            }
            tmp.add(nums[i]);
            dfs(nums, i+1, tmp, result);
            tmp.remove(tmp.size()-1);
        }
    }

    private static void subsetsHelper(ArrayList<ArrayList<Integer>> result,
        ArrayList<Integer> list, int[] num, int pos) {
        result.add(new ArrayList<Integer>(list));
        for (int i = pos; i < num.length; i++) {
            if ( i != pos && num[i] == num[i - 1]) {
                continue;
            }    
            list.add(num[i]);
            subsetsHelper(result, list, num, i + 1);
            list.remove(list.size() - 1);
        }
    }


}
