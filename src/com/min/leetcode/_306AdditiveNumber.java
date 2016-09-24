package com.min.leetcode;

public class _306AdditiveNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_306AdditiveNumber in = new _306AdditiveNumber();
		System.out.println(in.isAdditiveNumber("211738"));
	}

	public boolean isAdditiveNumber(String num) {
        if (num == null || num.length() == 0) {
            return false;
        }
        for (int i=0; i<num.length(); i++) {
            for (int j=i+1; j<num.length()-i-1; j++) {
                String first = num.substring(0, i+1);
                String second = num.substring(i+1, j+1);
                if (valid(j+1, num, first, second)) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean valid(int start, String num, String first, String second) {
        if (start == num.length()) {
            return true;
        }
        long f = Long.parseLong(first);
        long s = Long.parseLong(second);
        if(!Long.toString(f).equals(first) || !Long.toString(s).equals(second))  {  // to avoid 1023
        	return false;  
        }
        String sum = Long.toString(f+s);
        if (start + sum.length() > num.length()) {
            return false;
        }
        if (!sum.equals(num.substring(start, start+sum.length()))) {
            return false;
        }
        return valid(start+sum.length(), num, second, sum);
    }

}
