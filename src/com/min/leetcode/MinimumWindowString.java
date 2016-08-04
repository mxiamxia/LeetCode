import java.util.HashMap;


public class MinimumWindowString {

	/** 
	 * @author Min
	 * @date Jul 22, 2015
	 * @return void 
	 * @throws 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		minWindow("a", "aa");
		minWindow1("a", "aa");
	}

	public static String minWindow(String S, String T) {
	    if(S==null || S.length()==0)
	        return "";
	    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
	    for(int i=0; i<T.length();i++)
	    {
	        if(map.containsKey(T.charAt(i)))
	        {
	            map.put(T.charAt(i),map.get(T.charAt(i))+1);
	        }
	        else
	        {
	            map.put(T.charAt(i),1);
	        }
	    }
	    int left = 0;
	    int count = 0;
	    int minLen = S.length()+1;
	    int minStart = 0;
	    for(int right=0; right<S.length();right++)
	    {
	        if(map.containsKey(S.charAt(right)))
	        {
	            map.put(S.charAt(right),map.get(S.charAt(right))-1);
	            if(map.get(S.charAt(right))>=0)
	            {
	                count++;
	            }
	            while(count == T.length())
	            {
	                if(right-left+1<minLen)
	                {
	                    minLen = right-left+1;
	                    minStart = left;                    
	                }
	                if(map.containsKey(S.charAt(left)))
	                {
	                    map.put(S.charAt(left), map.get(S.charAt(left))+1);
	                    if(map.get(S.charAt(left))>0)
	                    {
	                        count--;
	                    }
	                }
	                left++;
	            }
	        }
	    }
	    if(minLen>S.length())
	    {
	        return "";
	    }
	    return S.substring(minStart,minStart+minLen);
	}
	
	public static String minWindow1(String s, String t) {
        if(s == null || t == null || s.length() == 0 || t.length() == 0) {
            return "";
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer> ();
        for(int i=0; i<t.length(); i++) {
            if(map.containsKey(t.charAt(i))) {
                map.put(t.charAt(i), map.get(t.charAt(i))+1);
            } else {
                map.put(t.charAt(i), 1);
            }
        }
        int left = 0;
        int count = 0;
        int pre = 0;
        int minLen = s.length()+1;
        for(int right=0; right<s.length(); right++) {
            if(map.containsKey(s.charAt(right))) {
                map.put(s.charAt(right), map.get(s.charAt(right))-1);
                if(map.get(s.charAt(right)) >= 0) {
                    count++;
                }
                while(count == t.length()) {
                    if(right-left+1 < minLen) {
                        minLen = right - left + 1;
                        pre = left;
                    }
                    if(map.containsKey(s.charAt(left))) {
                        map.put(s.charAt(left), map.get(s.charAt(left))+1);
                        if(map.get(s.charAt(left)) > 0) {
                            count--;
                        }
                    }
                    left++;
                }
            }
        }
        if(minLen > s.length()) {
            return "";
        }
        return s.substring(pre, pre+minLen);
    }
}
