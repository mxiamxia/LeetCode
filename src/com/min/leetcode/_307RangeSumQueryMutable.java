package com.min.leetcode;

public class _307RangeSumQueryMutable {

	/*
	 * 
	 * 这道题是之前那道Range Sum Query - Immutable 区域和检索 -
	 * 不可变的延伸，之前那道题由于数组的内容不会改变，所以我们只需要建立一个累计数组就可以支持快速的计算区间值了，而这道题说数组的内容会改变，
	 * 如果我们还是用之前的方法建立累计和数组，那么每改变一个数字，之后所有位置的数字都要改变，这样如果有很多更新操作的话，就会十分不高效。
	 * 这道题我们要使用一种新的数据结构，叫做树状数组Binary Indexed
	 * Tree，这是一种查询和修改复杂度均为O(logn)的数据结构。这个树状数组比较有意思，所有的奇数位置的数字和原数组对应位置的相同，
	 * 偶数位置是原数组若干位置之和，假如原数组A(a1, a2, a3, a4 ...)，和其对应的树状数组C(c1, c2, c3, c4
	 * ...)
	 * 
	 * 有如下关系： 
	 * C1 = A1
		C2 = A1 + A2
		C3 = A3
		C4 = A1 + A2 + A3 + A4
		C5 = A5
		C6 = A5 + A6
		C7 = A7
		C8 = A1 + A2 + A3 + A4 + A5 + A6 + A7 + A8
	 * 那么是如何确定某个位置到底是有几个数组成的呢，原来是根据坐标的最低位Low
	 * Bit来决定的，所谓的最低位，就是二进制数的最右边的一个1开始，加厚后面的0(如果有的话)组成的数字，例如1到8的最低位如下面所示：
	 * 
	 * 坐标 二进制 最低位
	 * 
	 * 1 0001 1
	 * 
	 * 2 0010 2
	 * 
	 * 3 0011 1
	 * 
	 * 4 0100 4
	 * 
	 * 5 0101 1
	 * 
	 * 6 0110 2
	 * 
	 * 7 0111 1
	 * 
	 * 8 1000 8
	 * 
	 * ...
	 * 
	 * 最低位的计算方法有两种，一种是x&(x^(x–1))，另一种是利用补码特性x&-x。
	 * 
	 * 这道题我们先根据给定输入数组建立一个树状数组bit，然后更新某一位数字时，根据最低位的值来更新后面含有这一位数字的地方，
	 * 一般只需要更新部分偶数位置的值即可，在计算某一位置的前缀和时，利用树状数组的性质也能高效的很快算出来，参见代码如下：
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	int[] btree;
    int[] arr;
 
    public _307RangeSumQueryMutable(int[] nums) {
        btree = new int[nums.length+1];
        arr = nums;
 
        for(int i=0; i<nums.length; i++){
            add(i+1, nums[i]);
        }
    }
 
    void add(int i, int val) {
        for(int j=i; j<btree.length; j=j+(j&(j^(j-1))) ){
            btree[j] += val;
        }
    }
 
    void update(int i, int val) {
        add(i+1, val-arr[i]);
        arr[i]=val;
    }
 
    public int sumRange(int i, int j) {
        return sumHelper(j+1)-sumHelper(i);
    }
 
    public int sumHelper(int i){
        int sum=0;
        for(int j=i; j>=1; j=j-(j&(-j))){
            sum += btree[j];
        }
        return sum;
    }

}
