package com.min.leetcode;

import java.util.Stack;

public class _227BasicCalculatorII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int calculate(String s) {
		int res = 0;
		if (s == null) {
			return res;
		}
		s = s.replaceAll(" ", "");
		Stack<String> stack = new Stack<String>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			StringBuilder sb = new StringBuilder();
			String v = stack.peek();
			if (c == '*') {
				stack.pop(); // pop *
				String num = stack.pop();
				int subRes = Integer.parseInt(num) * Integer.parseInt(cur);
				stack.push(String.valueOf(subRes));
			} else if (c == '/') {
				stack.pop(); // pop *
				String num = stack.pop();
				int subRes = Integer.parseInt(num) / Integer.parseInt(cur);
				stack.push(String.valueOf(subRes));
			} else {
				sb.append(c);
				stack.push(cur);
			}
		}
		while (!stack.isEmpty()) {
			String v = stack.peek();
			if (v.equals("+")) {
				stack.pop(); // pop *
				String num = stack.pop();
				res += Integer.parseInt(num);
			} else if (v.equals("-")) {
				stack.pop();
				String num = stack.pop();
				res -= Integer.parseInt(num);
			} else {
				String num = stack.pop();
				res += Integer.parseInt(num);
			}
		}
		return res;
	}
	
	
	public int calculate1(String s) {
	    int md=-1; // 0 is m, 1 is d
	    int sign=1; // 1 is +, -1 is -
	    int prev=0;
	    int result=0;
	 
	    for(int i=0; i<s.length(); i++){
	        char c = s.charAt(i);
	        if(Character.isDigit(c)){
	            int num = c-'0';
	            while(++i<s.length() && Character.isDigit(s.charAt(i))){
	                num = num*10+s.charAt(i)-'0';
	            }
	            i--; // back to last digit of number
	 
	            if(md==0){
	                prev = prev * num;
	                md=-1;
	            }else if(md==1){
	                prev = prev / num;
	                md=-1;
	            }else{
	                prev = num;
	            }
	        }else if(c=='/'){
	            md=1;
	        }else if(c=='*'){
	            md=0;
	        }else if(c=='+'){
	            result = result + sign*prev;
	            sign=1;
	        }else if(c=='-'){
	            result = result + sign*prev;
	            sign=-1;
	        }
	    }
	 
	    result = result + sign*prev;
	    return result;
	}
}
