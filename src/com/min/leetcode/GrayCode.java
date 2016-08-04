import java.util.ArrayList;


public class GrayCode {

	/** 
	 * @author Min
	 * @date Aug 25, 2015
	 * @return void 
	 * @throws 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		grayCode(3);
	}
	
    public static ArrayList<Integer> grayCode(int n) {
        if(n==0) {
            ArrayList<Integer> result = new ArrayList<Integer>();
            result.add(0);
            return result;
        }
        
        ArrayList<Integer> tmp = grayCode(n-1);
        int addNumber = 1 << (n-1);
        ArrayList<Integer> result = new ArrayList<Integer>(tmp);
        for(int i=tmp.size()-1;i>=0;i--) {
            result.add(addNumber + tmp.get(i));
        }
        return result;
    }

}
