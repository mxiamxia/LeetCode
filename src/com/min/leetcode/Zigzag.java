
public class Zigzag {

	/** 
	 * @author Min
	 * @date May 11, 2015
	 * @return void 
	 * @throws 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(convert("AB", 2));
	}
	
	public static String convert(String s, int nRows) {  
        if(s == null || s.length()==0 || nRows <=0)  
            return "";  
        if(nRows == 1)  
            return s;
            
        StringBuilder res = new StringBuilder();  
        int size = 2*nRows-2;  
        for(int i=0;i<nRows;i++){  
            for(int j=i;j<s.length();j+=size){  
                res.append(s.charAt(j));  
                if(i != 0 && i != nRows - 1){//except the first row and the last row
                    int temp = j+size-2*i;
                    if(temp<s.length())
                        res.append(s.charAt(temp));
                }
            }                  
        }  
        return res.toString();  
    }

}
