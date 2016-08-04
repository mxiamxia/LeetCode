import java.util.ArrayList;
import java.util.List;


public class TextJustification {

	/** 
	 * @author Min
	 * @date Jul 21, 2015
	 * @return void 
	 * @throws 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] input = {"This", "is", "an", "example", "of", "text", "justification."};
//		fullJustify(input, 16);
		fullJustify1(input, 16);
	}
	
	 public static List<String> fullJustify1(String[] words, int maxWidth) {
	        List<String> res = new ArrayList<String> ();
	        if(words == null || words.length == 0) {
	            return res;
	        }
	        int count = 0;
	        int last = 0;
	        for(int i=0; i<words.length; i++) {
	            if(count + words[i].length() + (i-last) > maxWidth) {
	                int numSpace = 0;
	                int extraSpace = 0;
	                if((i-last-1) > 0) {
	                    numSpace = (maxWidth - count)/(i-last-1);
	                    extraSpace = (maxWidth - count)%(i-last-1);
	                }
	                StringBuffer sb = new StringBuffer();
	                for(int j=last; j<i; j++) {
	                    sb.append(words[j]);
	                    last++;
	                    if(j<i-1) {
	                        for(int k=0; k<numSpace; k++) {
	                            sb.append(" ");
	                        }
	                        if(extraSpace > 0) {
	                            sb.append(" ");
	                        }
	                        extraSpace--;
	                    }
	                }
	                for(int ii=sb.length(); ii<maxWidth; ii++) {
	                    sb.append(" ");
	                }
	                res.add(sb.toString());
	                last = i;
	                count = 0;
	            }
	            count = count + words[i].length();
	        }
	        // last row
	        StringBuffer sb = new StringBuffer();
	        for(int i=last; i<words.length; i++) {
	            sb.append(words[i]);
	            if(sb.length() < maxWidth) {
	                sb.append(" ");
	            }
	        }
	        for(int l=sb.length(); l<maxWidth; l++) {
	            sb.append(" ");
	        }
	        res.add(sb.toString());
	        return res;
	    }

	public static ArrayList<String> fullJustify(String[] words, int L) {
	    ArrayList<String> res = new ArrayList<String>();
	    if(words==null || words.length==0)
	        return res;
	    int count = 0;
	    int last = 0;
	    for(int i=0;i<words.length;i++){
	        //count是上一次计算的单词的长度，words[i].length()是当前尝试放的一个单词的长度，
	        //假设当前放上了这个单词，那么这一行单词跟单词间的间隔数就是i-last
	        //判断这些总的长度加起来是不是大于L（超行数了）
	        if(count + words[i].length() + (i-last) > L){
	            int spaceNum = 0;
	            int extraNum = 0;
	            //因为尝试的words[i]失败了，所以间隔数减1.此时判断剩余的间隔数是否大于0
	            if( i-last-1 >0){
	                //是间隔的倍数（为啥要减1，因为尝试当前words[i]后发现比L长了，
	                //所以当前这个单词不能算作这行，所以间隔就减少一个
	                spaceNum = (L-count)/(i-last-1);
	                extraNum = (L-count)%(i-last-1);//不是倍数的话还要计算
	            }
	            StringBuilder str = new StringBuilder();
	            for(int j=last;j<i;j++){
	                str.append(words[j]);
	                if(j<i-1){//words[i-1]的话后面就不用填空格了，所以这里j<i-1
	                    for(int k=0;k<spaceNum;k++)
	                        str.append(" ");
	                    
	                    if(extraNum>0)
	                        str.append(" ");
	                    
	                    extraNum--;
	                }
	            }
	            
	            //下面这个for循环作用于一行只有一个单词还没填满一行的情况
	            for(int j=str.length();j<L;j++)
	                str.append(" ");
	                
	            res.add(str.toString());
	            count=0;
	            last=i;//下一个开始的单词
	        }
	        count += words[i].length();
	    }
	    
	    //处理最后一行
	    StringBuilder str = new StringBuilder();
	    for(int i=last;i<words.length;i++){
	        str.append(words[i]);
	        if(str.length()<L)
	            str.append(" ");
	    }
	    for(int i=str.length();i<L;i++)
	        str.append(" ");
	    
	    res.add(str.toString());
	    return res;
	}
}
