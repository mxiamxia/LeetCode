package com.min.leetcode;

public class _168ExcelSheetTittle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		convertToTitle(52);
	}
	public static String convertToTitle(int n) {
	    if(n <= 0){
	        throw new IllegalArgumentException("Input is not valid!");
	    }
	 
	    StringBuilder sb = new StringBuilder();
	 
	    while(n > 0){
	        n--;
	        char ch = (char) (n % 26 + 'A');
	        n /= 26;
	        sb.append(ch);
	    }
	 
	    sb.reverse();
	    return sb.toString();
	}
	
	public static int binaryToDecimal(String str){
	    double j=0;
	    for(int i=0;i<str.length();i++){
	        if(str.charAt(i)== '1'){
	         j=j+ Math.pow(2,str.length()-1-i);
	     }

	    }
	    return (int) j;
	}
	public int[] convertBinary(int no) {
	    int i = 0, temp[] = new int[7];
	    int binary[];
	    while (no > 0) {
	        temp[i++] = no % 2;
	        no /= 2;
	    }
	    binary = new int[i];
	    int k = 0;
	    for (int j = i - 1; j >= 0; j--) {
	        binary[k++] = temp[j];
	    }

	    return binary;
	}
	

}
