package com.min.leetcode;

public class _233NumberDigitOne {
	
	/*
	 * Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.

		For example:
		Given n = 13,
		Return 6, because digit 1 occurred in the following numbers: 1, 10, 11, 12, 13.
	 * 
	 * 
	 * 这道题让我们比给定数小的所有数中1出现的个数，之前有道类似的题Number of 1 Bits 位1的个数，
	 * 那道题是求转为二进数后1的个数，我开始以为这道题也是要用那题的方法，其实不是的，这题实际上相当于一道找规律的题。
	 * 那么为了找出规律，我们就先来列举下所有含1的数字，并每10个统计下个数，如下所示：

		1的个数          含1的数字                                                                        数字范围
		
		1                   1                                                                                     [1, 9]
		
		11                 10  11  12  13  14  15  16  17  18  19                              [10, 19]
		
		1                   21                                                                                   [20, 29]
		
		1                   31                                                                                   [30, 39]
		
		1                   41                                                                                   [40, 49]
		
		1                   51                                                                                   [50, 59]
		
		1                   61                                                                                   [60, 69]
		
		1                   71                                                                                   [70, 79]
		
		1                   81                                                                                   [80, 89]
		
		1                   91                                                                                   [90, 99]
		
		11                 100  101  102  103  104  105  106  107  108  109          [100, 109]
		
		21                 110  111  112  113  114  115  116  117  118  119             [110, 119]
		
		11                 120  121  122  123  124  125  126  127  128  129          [120, 129]
		
		...                  ...                                                                                  ...
		
		 
		
		通过上面的列举我们可以发现，100以内的数字，除了10-19之间有11个‘1’之外，其余都只有1个。
		如果我们不考虑[10, 19]区间上那多出来的10个‘1’的话，那么我们在对任意一个两位数，
		十位数上的数字(加1)就代表1出现的个数，这时候我们再把多出的10个加上即可。比如56就有(5+1)+10=16个。
		如何知道是否要加上多出的10个呢，我们就要看十位上的数字是否大于等于2，是的话就要加上多余的10个'1'。
		那么我们就可以用(x+8)/10来判断一个数是否大于等于2。对于三位数也是一样，除了[110, 119]之间多出的10个数之外，
		其余的每10个数的区间都只有11个‘1’，那么还是可以用相同的方法来判断并累加1的个数，参见代码如下：
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		countDigitOne(122);
	}
	public static int countDigitOne(int n) {  
        int ones = 0;  
        for (long m = 1; m <= n; m *= 10) {  
            long a = n/m, b = n%m;  
            ones += (a + 8) / 10 * m;  
            if(a % 10 == 1) ones += b + 1;  
        }  
        return ones;  
    } 

}
