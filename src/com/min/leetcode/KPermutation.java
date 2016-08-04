import java.util.ArrayList;
import java.util.List;


public class KPermutation {

	/** 
	 * @author Min
	 * @date Jul 7, 2015
	 * @return void 
	 * @throws 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getPermutation(3, 3);
	}
	
	public static String getPermutation(int n, int k) {  
        k--;//to transfer it as begin from 0 rather than 1
        
        List<Integer> numList = new ArrayList<Integer>();  
        for(int i = 1; i<= n; i++)
            numList.add(i);
       
        int factorial = 1;    
        for(int i = 2; i < n; i++)  
            factorial *= i;    
        
        StringBuilder res = new StringBuilder();
        int times = n-1;
        while(times>=0){
            int indexInList = k/factorial;
            res.append(numList.get(indexInList));  
            numList.remove(indexInList);  
            
            k = k%factorial;//new k for next turn
            if(times!=0)
                factorial = factorial/times;//new (n-1)!
            
            times--;
        }
        
        return res.toString();
    }

}
