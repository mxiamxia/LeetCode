
public class UniqueBSTI {

	/** 
	 * @author Min
	 * @date Aug 31, 2015
	 * @return void 
	 * @throws 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numTrees(3));
	}

	  public static int numTrees(int n) {
	        int[] num = new int[n+1];
	        num[0] = 1;
	        num[1] = 1;
	        for(int i=2; i<=n; i++) {
	            for(int j=0; j<=i-1; j++) {
	                num[i] = num[i] + num[j]*num[i-j-1];
	            }
	        }
	        return num[n];
	    }
}
