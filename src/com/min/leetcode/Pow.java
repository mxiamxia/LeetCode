
public class Pow {

	/** 
	 * @author Min
	 * @date Jun 17, 2015
	 * @return void 
	 * @throws 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Pow().test();
	}
	
	private void test() {
		// TODO Auto-generated method stub
		pow(2, 3);
	}

	public double power(double x, int n) {
		if (n == 0)
			return 1;
	 
		double v = power(x, n / 2);
	 
		if (n % 2 == 0) {
			return v * v;
		} else {
			return v * v * x;
		}
	}
	 
	public double pow(double x, int n) {
		if (n < 0) {
			return 1 / power(x, -n);
		} else {
			return power(x, n);
		}
	}

}
