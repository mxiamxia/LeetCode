
public class TrappingWater {

	/** 
	 * @author Min
	 * @date Jun 10, 2015
	 * @return void 
	 * @throws 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TrappingWater().test();
	}

	private void test() {
		// TODO Auto-generated method stub
		int[] input = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(trap(input));
	}

	public int trap(int[] A) {
	    if(A==null || A.length==0)
	        return 0;
	    int max = 0;
	    int res = 0;
	    int[] container = new int[A.length];
	    for(int i=0;i<A.length;i++)
	    {
	        container[i]=max;
	        max = Math.max(max,A[i]);
	    }
	    max = 0;
	    for(int i=A.length-1;i>=0;i--)
	    {
	        container[i] = Math.min(max,container[i]);
	        max = Math.max(max,A[i]);
	        res += container[i]-A[i]>0?container[i]-A[i]:0;
	    }    
	    return res;
	}
}
