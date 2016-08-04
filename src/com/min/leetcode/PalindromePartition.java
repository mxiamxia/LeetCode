import java.util.ArrayList;
import java.util.List;


public class PalindromePartition {

	/** 
	 * @author Min
	 * @date Sep 16, 2015
	 * @return void 
	 * @throws 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new PalindromePartition().partition("a");
	}

	public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        if(s == null || s.length() == 0) {
            return res;
        }
        List<String> item = new ArrayList<String>();
        dfs(s, 0, item, res);
        return res;
    }
    public void dfs(String s, int start, List<String> item, List<List<String>> res) {
        if(start == s.length()-1) {
            res.add(new ArrayList(item));
            return;
        }
        for(int i=start; i<s.length(); i++) {
            String str = s.substring(start, i+1);
            if(isPalindrome(str)) {
                item.add(str);
                dfs(s, i+1, item, res);
                item.remove(item.size()-1);
            }
        }
    }
    public boolean isPalindrome(String s) {
        int begin = 0;
        int end = s.length()-1;
        while(begin < end) {
            if(s.charAt(begin) == s.charAt(end)) {
                begin++;
                end--;
            }
            else {
                return false;
            }
        }
        return true;
    }
}
