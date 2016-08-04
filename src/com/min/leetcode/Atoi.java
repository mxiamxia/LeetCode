package com.min.leetcode;


public class Atoi {

	/** 
	 * @author Min
	 * @date May 11, 2015
	 * @return void 
	 * @throws 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Atoi().myAtoi("+123"));
	}
	
	public int myAtoi(String str) {
        long res = 0;
        boolean flag = false;
        if(str == null)
        {
            return 0;
        }
        
        if(str.length() == 0)
        {
            return 0;
        }
        
        for(int i = 0; i<=str.length()-1; i++)
        {

        	if(str.charAt(i)=='-')
        	{
        		flag = true;
        		continue;
        	}
        	if(str.charAt(i)=='+')
        	{
        		continue;
        	}


        	if(str.charAt(i)==' ')
        	{
        		continue;
        	}

        	if(str.charAt(i) >=48 && str.charAt(i) <=57 )
        	{
        		res = res*10 + (str.charAt(i)-48);
        	}

        	else
        	{
        		return 0;
        	}
        }
        
        if(res>Integer.MAX_VALUE)
        {
            return 0;
        }
        
        if(flag)
        {
            res = 0-res;
        }
        
        return (int) res;
        
    }

}
