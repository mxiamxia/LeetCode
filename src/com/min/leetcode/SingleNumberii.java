
public class SingleNumberii {

	/** 
	 * @author Min
	 * @date Sep 21, 2015
	 * @return void 
	 * @throws 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {5, 5, 5, 4};
		new SingleNumberii().singleNumber(input, 4);
	}
	
	int singleNumber(int A[], int n) {
	    int ones = 0, twos = 0, threes = 0;
	    for (int i = 0; i < n; i++) {
	        twos |= ones & A[i];
	        ones ^= A[i];// 异或3次 和 异或 1次的结果是一样的
	       //对于ones 和 twos 把出现了3次的位置设置为0 （取反之后1的位置为0）
	        threes = ones & twos;
	        ones &= ~threes;
	        twos &= ~threes;
	    }
	    return ones;
	}

}
