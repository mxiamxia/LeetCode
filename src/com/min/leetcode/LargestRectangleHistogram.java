import java.util.Stack;


public class LargestRectangleHistogram {

	/** 
	 * @author Min
	 * @date Jul 23, 2015
	 * @return void 
	 * @throws 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input ={2,1,5,6,2,3};
		largestRectangleArea(input);
	}

	public static int largestRectangleArea(int[] height) {
	    if(height==null || height.length==0)
	        return 0;
	    int max = 0;
	    Stack<Integer> stack = new Stack<Integer>();
	    for(int i=0;i<height.length;i++)
	    {
	        while(!stack.isEmpty() && height[i]<=height[stack.peek()])
	        {
	            int index = stack.pop();
	            int curArea = stack.isEmpty()?i*height[index]:(i-stack.peek()-1)*height[index];
	            max = Math.max(max,curArea);
	        }
	        stack.push(i);
	    }
	    while(!stack.isEmpty())
	    {
	        int index = stack.pop();
	        int curArea = stack.isEmpty()?height.length*height[index]:(height.length-stack.peek()-1)*height[index];
	        max = Math.max(max,curArea);            
	    }
	    return max;
	}
}
