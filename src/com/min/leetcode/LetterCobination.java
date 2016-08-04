import java.util.ArrayList;
import java.util.List;


public class LetterCobination {

	/** 
	 * @author Min
	 * @date May 19, 2015
	 * @return void 
	 * @throws 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List l = letterCombinations("123");
	}
	
	public static ArrayList<String> letterCombinations(String digits) {
		String[] ss = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		
		ArrayList<String> ret = new ArrayList<String>();
		digits = digits.replace("1", "");
		digits = digits.replace("0", "");
		rec(ret, digits.length(), ss, digits, new StringBuffer());
		return ret;
    }
	
	public static void rec(ArrayList<String> ret, int remain, String[] ss, String digits, StringBuffer sb){
		// ???digits????
		if(remain == 0){
			ret.add(sb.toString());
			return;
		}
		
		String s = ss[digits.charAt(0)-'0'];		// ??digits[0]???string s
		// DFS
		for(int i=0; i<s.length(); i++){
			sb = sb.append(s.charAt(i));
			rec(ret, remain-1, ss, digits.substring(1), sb);
			sb.deleteCharAt(sb.length()-1);		// ????
		}
	}

}
