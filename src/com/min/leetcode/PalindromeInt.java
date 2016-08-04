
public class PalindromeInt {

	/** 
	 * @author Min
	 * @date May 11, 2015
	 * @return void 
	 * @throws 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPalindrome(1));
	}
	
	public static boolean isPalindrome(int x) {
        if(x<0)
        {
            return false;
        }
        
        int p = x;
        int res = 0;
        while(p>0)
        {
            res = res*10 + p%10;
            p = p/10;
        }
        
        if(x == res)
        {
            return true;
        }
        else
        {
            return false;
        }
        
    }

}
