import java.util.ArrayList;


public class PivatesBar {

	/** 
	 * @author Min
	 * @date Jun 24, 2015
	 * @return void 
	 * @throws 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] input = {1,2,3,4,5,6,7,8,9,2};
		int[] input = {1,3,0,1};
		int ret = answer(input);
		System.out.println(ret);
	}
	
	public static int answer(int[] numbers) { 
        // Your code goes here.
        int res = 0;
        if(numbers == null || numbers.length == 0) {
            return res;
        }
//        ArrayList<Integer> list = new ArrayList<Integer>();
        boolean[] flag = new boolean[numbers.length];
        res = helper(numbers, 0, 0, flag);
        return res;
    } 
    private static int helper(int[] numbers, int idx, int res, boolean[] flag) {
    	flag[idx] = true;
        if(flag[numbers[idx]]) {
            return res;
        }
        return helper(numbers, numbers[idx], res+1, flag);
    }
    
    public static int answer1(int[] numbers) { 
        
        int first_pirate = 0;
        int current_pirate = numbers[first_pirate];
        int max_size = 5000;
        int[] count = new int[max_size];
        boolean[] array = new boolean[max_size];
        array[first_pirate] = true;
        increment(array, count);
        while(array[current_pirate] != true) {
            if(array[current_pirate] != true) {
                array[current_pirate] = true;
                current_pirate = numbers[current_pirate];
                increment(array, count);
            }
        }
        return count[current_pirate];
    }
    
    private static void increment(boolean[] arr, int[] count){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == true){
                count[i] += 1;
            }
        }
    }

}
