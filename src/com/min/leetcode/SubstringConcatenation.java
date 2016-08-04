import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SubstringConcatenation {

	/** 
	 * @author Min
	 * @date Jun 2, 2015
	 * @return void 
	 * @throws 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "lingmindraboofooowingdingbarrwingmonkeypoundcake";
		String[] words = {"fooo","barr","wing","ding","wing"};
		new SubstringConcatenation().findSubstring(s, words);
	}

	public List<Integer> findSubstring(String s, String[] words) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        if(words.length == 0 || s.length() == 0)
        {
            return ret;
        }
        int l=s.length(), n = words.length, m = words[0].length();
        
        Map<String, Integer> map = new HashMap<String, Integer>();
        for(int i=0;i<n;i++)
        {
            if(map.containsKey(words[i]))
            {
                map.put(words[i], map.get(words[i])+1);
            }
            else
            {
                map.put(words[i], 1);
            }
        }
        int k=0;
        while(l-k > n*m)
        {
            Map<String, Integer> temp = new HashMap<String, Integer>(map);
            for(int i=0;i<n;i++)
            {
                String sub = s.substring(k+i*m, k+(i+1)*m);
                if(temp.containsKey(sub))
                {
                    if(temp.get(sub) == 1)
                    {
                        temp.remove(sub);
                    }
                    else
                    {
                        temp.put(sub, temp.get(sub)-1);
                    }
                }
                else
                {
                    break;
                }
            }
            if(temp.size()==0)
            {
                ret.add(k);
            }
            k++;
        }
        return ret;
    }
}
