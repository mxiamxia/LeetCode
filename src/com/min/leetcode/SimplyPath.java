import java.util.Stack;


public class SimplyPath {

	/** 
	 * @author Min
	 * @date Jul 21, 2015
	 * @return void 
	 * @throws 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		simplifyPath("/...");
	}

	public static String simplifyPath(String path) {
        if(path == null || path.length() == 0) {
            return path;
        }
        String[] list = path.split("/");
        Stack<String> stack = new Stack<String> ();
        for(String d : list) {
            if(".".equals(d) || d.length() == 0) {
                continue;
            } else if("..".equals(d)) {
                if(!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(d);
            }
        }
        Stack<String> tmp = new Stack<String> ();
        while(!stack.isEmpty()) {
            tmp.push(stack.pop());
        }
        StringBuffer sb = new StringBuffer();
        
        while(!tmp.isEmpty()) {
            sb.append("/" + tmp.pop());
        }
        if(sb.length() == 0) {
            sb.append("/");
        }
        return sb.toString();
    }
}
