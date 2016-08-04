import java.util.ArrayList;


public class RestoreIPAddress {

	/** 
	 * @author Min
	 * @date Aug 26, 2015
	 * @return void 
	 * @throws 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(restoreIpAddresses("25525511135"));
	}
	
	public static ArrayList<String> restoreIpAddresses(String s) {  
        ArrayList<String> res = new ArrayList<String>();  
        String item = new String();
        if (s.length()<4||s.length()>12) 
        return res;  
        
        dfs(s, 0, item, res);  
        return res;  
    }  
      
    public static void dfs(String s, int start, String item, ArrayList<String> res){  
        if (start == 3 && isValid(s)) {  
            res.add(item + s);  
            return;  
        }  
        for(int i=0; i<3 && i<s.length(); i++){  
            String substr = s.substring(0,i+1);  
            if (isValid(substr))
                dfs(s.substring(i+1, s.length()), start+1, item + substr + '.', res);  
        }  
    }  
      
    public static boolean isValid(String s){  
        if (s.charAt(0)=='0')
            return s.equals("0");  
            int num = Integer.parseInt(s);
            
        if(num <= 255 && num > 0)
            return true;
        else
            return false;
    }

}
