
public class PlusOne {

	/** 
	 * @author Min
	 * @date Jun 3, 2015
	 * @return void 
	 * @throws 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new PlusOne().test());

	}

	private int[] test() {
		// TODO Auto-generated method stub
		int[] input = {1,0,0,0,0};
		return plusOne(input);
	}

	public int[] plusOne(int[] digits) {
        if(digits.length == 0){
            return null;
        }
        int carry = 1;
        int l = digits.length;
        int[] ret = new int[l+1];
        for(int i=l-1; i>=0; i--){
            int sum = digits[i] + carry;
            int mod = sum%10;
            if(mod == 0 && sum == 10){
            	mod = 0;
            	carry = 1;
            }else {
            	mod = sum;
            	carry = 0;
            }
        }
        if(carry == 0) {
            return digits;
        }else {
            ret[0] = 1;
            for(int j=0;j<l-1;j++)
            {
                ret[j+1] = digits[j];
            }
        }
        return ret;
    }
}
