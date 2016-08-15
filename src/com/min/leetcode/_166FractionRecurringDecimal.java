package com.min.leetcode;

import java.util.HashMap;
import java.util.Map;

public class _166FractionRecurringDecimal {
	
	/*
	 * Problem

		Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
		
		If the fractional part is repeating, enclose the repeating part in parentheses.
		
		For example,
	 * 
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		fractionToDecimal(1, 99);
	}
	
	
	public static String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        if (denominator == 0) {
            return "";
        }
        String result = "";
        if (numerator > 0 ^ denominator > 0) {
            result += "-";
        }
        long numer = (long) numerator;
        long den = (long) denominator;
        numer = Math.abs(numer);
        den = Math.abs(den);
        long res = numer / den;
        result += res;
        long remainder = numer % den;
        if (remainder == 0) {
            return result;
        }
        remainder = remainder * 10;
        Map<Long, Integer> map = new HashMap<Long, Integer>();
        result += ".";
        while(remainder != 0) {
            if (map.containsKey(remainder)) {
            	int len = map.get(remainder);
                String part1 = result.substring(0, len);
                String part2 = result.substring(len, result.length());
                result = part1 + "(" + part2 + ")";
                return result;
            }
            map.put(remainder, result.length());
            long res1 = remainder / den;
            result += res1;
            remainder = (remainder % den) * 10;
        }
        return result;
    }
	

}
