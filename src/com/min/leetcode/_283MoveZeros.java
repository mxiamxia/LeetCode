package com.min.leetcode;

public class _283MoveZeros {
	/*
	 * Given an array nums, write a function to move all 0's to the end of it
	 * while maintaining the relative order of the non-zero elements.
	 * 
	 * For example, given nums = [0, 1, 0, 3, 12], after calling your function,
	 * nums should be [1, 3, 12, 0, 0].
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] {1, 0, 0, 2, 3};
		_283MoveZeros in = new _283MoveZeros();
		in.moveZeroes1(nums);
	}
	
	public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == 0) {
                for (int j=i+1; j<nums.length; j++) {
                    if (nums[j] != 0) {
                        swap(i, j, nums);
                        break;
                    }
                }
            }
        }
    }
    private void swap(int i, int j, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    
    public void moveZeroes1(int[] nums) {
        int m=-1; 
     
        for(int i=0; i<nums.length; i++){
            if(nums[i]==0){
                if(m==-1 || nums[m]!=0){
                    m=i;
                }
            }else{
                if(m!=-1){
                    int temp = nums[i];
                    nums[i]=nums[m];
                    nums[m]=temp;
                    m++;
                }
            }
        }
    }
    
    public void moveZeroes2(int[] nums) {
        int i=0;
        int j=0;
     
        while(j<nums.length){
            if(nums[j]==0){
                j++;
            }else{
                nums[i]=nums[j];
                i++;
                j++;
            }
        }
     
        while(i<nums.length){
            nums[i]=0;
            i++;
        }
    }

}
