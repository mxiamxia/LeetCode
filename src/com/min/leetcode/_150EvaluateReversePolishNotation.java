package com.min.leetcode;

import java.util.Stack;

public class _150EvaluateReversePolishNotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int evalRPN(String[] tokens) {
        String ops = "+-*/";
        Stack<String> stack = new Stack<String>();
        for(String token : tokens) {
            if (!ops.contains(token)) {
                stack.push(token);
            } else {
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());
                switch (token) {
                    case "+" :
                        stack.push(String.valueOf(a+b));
                        break;
                    case "-" :
                        stack.push(String.valueOf(b-a));
                        break;
                    case "*" :
                        stack.push(String.valueOf(a*b));
                        break;
                    case "/" :
                        stack.push(String.valueOf(b/a));
                        break;
                }
            }
        }
        return Integer.parseInt(stack.pop());
    }

}
