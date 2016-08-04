
public class LastWordLength {

	/** 
	 * @author Min
	 * @date Jul 1, 2015
	 * @return void 
	 * @throws 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		lengthOfLastWord("     abc");
	}
	
	public static int lengthOfLastWord(String s) {
        int ret = 0;
        if(s == null || s.length() == 0) {
            return ret;
        }
        boolean flag = false;
        int end = s.length();
        int start = -1;
        for(int i=s.length()-1; i>=0; i--) {
            if(s.charAt(i) == ' ') {
                if(!flag) {
                    end--;
                } else {
                    break;
                }
            } else {
                flag = true;
                start = i;
            }
        }
        if(start != -1) {
            ret = s.substring(start, end).length();
        } 
        return ret;
    }

}
