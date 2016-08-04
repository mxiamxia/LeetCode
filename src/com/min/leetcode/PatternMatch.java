public class PatternMatch {

	/**
	 * @author Min
	 * @date Jun 12, 2015
	 * @return void
	 * @throws
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		isMatch("aa", "aa");
	}
/*
	public static boolean isMatch(String s, String p) {
		int i = 0;
		int j = 0;
		int star = -1;
		int mark = -1;
		while (i < s.length()) {
			if (j < p.length()
					&& (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) {
				++i;
				++j;
			} else if (j < p.length() && p.charAt(j) == '*') {
				star = j;
				j++;
				mark = i;
				
			} else if (star != -1) {
				j = star + 1;
				i = ++mark;
			} else {
				return false;
			}
		}
		
		while (j < p.length() && p.charAt(j) == '*') {
			++j;
		}
		return j == p.length();
	}
	*/

	public static boolean isMatch(String s, String p) {
	        if(p.length() == 0) {
	            return s.length() == 0;
	        }
	        int star = -1;
	        int mark = -1;
	        int i = 0;
	        int j = 0;
	        while(i < s.length()) {
	            if (j < p.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
	                i++;
	                j++;
	            } else if(j < p.length() && p.charAt(j) == '*') {
	                star = j;
	                mark = i;
	                j++;
	            } else if(star != -1) {
	                i = ++mark;
	                j = star + 1;
	            } else {
	                return false;
	            }
	        }
	        while(j < p.length() && p.charAt(j) == '*') {
	            j++;
	        }
	        
	        return j == p.length();
	    }
}
