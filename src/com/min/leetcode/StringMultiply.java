package com.min.leetcode;


public class StringMultiply {

	/** 
	 * @author Min
	 * @date Jun 12, 2015
	 * @return void 
	 * @throws 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(multiply("98", "9"));
	}
	
	public static String multiply(String num1, String num2) {
        if(num1 == null || num2 == null) {
            return null;
        }
//        num1 = new StringBuilder(num1).reverse().toString();
//        num2 = new StringBuilder(num2).reverse().toString();
        int num1_l = num1.length();
        int num2_l = num2.length();
        int[] seq = new int[num1_l + num2_l];
        for(int i = num1_l - 1; i >= 0; i--) {
            for(int j = num2_l - 1; j >= 0; j--) {
                seq[i+ j + 1] += (num1.charAt(i)-'0') * (num2.charAt(j)-'0');
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int k = seq.length - 1; k >=0; k--) {
            int digit = seq[k] % 10;
            int carry = seq[k] / 10;
            sb.insert(0, digit);
            if(k-1 >= 0) {
                seq[k - 1] += carry;
            }
        }
        
        while(sb.charAt(0) == '0' && sb.length() > 1) {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }

}
