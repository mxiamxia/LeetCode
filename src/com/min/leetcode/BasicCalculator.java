package com.min.leetcode;

import java.util.ArrayList;
import java.util.Stack;


public class BasicCalculator {

	/** 
	 * @author Min
	 * @date Jun 23, 2015
	 * @return void 
	 * @throws 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new BasicCalculator().test();
	}
	
	private void test() {
		// TODO Auto-generated method stub
		System.out.println(calculate("1"));
	}
	public int calculate(String s) {
        int ret = 0;
        s = s.replaceAll(" ", "");
        s = "(" + s +")";
        char[] arr = s.toCharArray();
        Stack<String> stack = new Stack<String>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i< arr.length-1; i++) {
        	if(arr[i] >= '0' && arr[i] <= '9') {
        		sb.append(new String(new char[]{arr[i]}));
        		if(i == arr.length-1) {
        			stack.push(sb.toString());
        		}
        	} else {
                if(sb.length() > 0) {
                    stack.push(sb.toString());
                    sb = new StringBuilder();
                }
                if(arr[i] != ')') {
                    stack.push(String.valueOf(arr[i]));
                } else {
                    ArrayList<String> list = new ArrayList<String>();
                    while(!stack.isEmpty()) {
                        String top = stack.pop();
                        if(top.equals("(")) {
                            break;
                        } else {
                            list.add(0, top);
                        }
                    }
                    int temp = 0;
                    if(list.size() == 1) {
                        temp = Integer.valueOf(list.get(0));
                    } else {
                        for(int j=list.size()-1; j>0; j=j-2) {
                            if(list.get(j-1).equals("-")) {
                                temp += 0 - Integer.valueOf(list.get(j));
                            } else {
                                temp += Integer.valueOf(list.get(j));
                            }
                        }
                        temp += Integer.valueOf(list.get(0));
                    }
                    stack.push(String.valueOf(temp));
                    ret = temp;
                }
            }
        }
        return ret;
    }

	public int calculate1(String s) {
		// delte white spaces
		s = s.replaceAll(" ", "");
	 
		Stack<String> stack = new Stack<String>();
		char[] arr = s.toCharArray();
	 
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == ' ')
				continue;
	 
			if (arr[i] >= '0' && arr[i] <= '9') {
				sb.append(arr[i]);
	 
				if (i == arr.length - 1) {
					stack.push(sb.toString());
				}
			} else {
				if (sb.length() > 0) {
					stack.push(sb.toString());
					sb = new StringBuilder();
				}
	 
				if (arr[i] != ')') {
					stack.push(new String(new char[] { arr[i] }));
				} else {
					// when meet ')', pop and calculate
					ArrayList<String> t = new ArrayList<String>();
					while (!stack.isEmpty()) {
						String top = stack.pop();
						if (top.equals("(")) {
							break;
						} else {
							t.add(0, top);
						}
					}
	 
					int temp = 0;
					if (t.size() == 1) {
						temp = Integer.valueOf(t.get(0));
					} else {
						for (int j = t.size() - 1; j > 0; j = j - 2) {
							if (t.get(j - 1).equals("-")) {
								temp += 0 - Integer.valueOf(t.get(j));
							} else {
								temp += Integer.valueOf(t.get(j));
							}
						}
						temp += Integer.valueOf(t.get(0));
					}
					stack.push(String.valueOf(temp));
				}
			}
		}
	 
		ArrayList<String> t = new ArrayList<String>();
		while (!stack.isEmpty()) {
			String elem = stack.pop();
			t.add(0, elem);
		}
	 
		int temp = 0;
		for (int i = t.size() - 1; i > 0; i = i - 2) {
			if (t.get(i - 1).equals("-")) {
				temp += 0 - Integer.valueOf(t.get(i));
			} else {
				temp += Integer.valueOf(t.get(i));
			}
		}
		temp += Integer.valueOf(t.get(0));
	 
		return temp;
	}

}
