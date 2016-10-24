package com.min.leetcode;

public class _75SetColor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_75SetColor in = new _75SetColor();
		in.sortColors(new int[]{0});
	}

	public void sortColors(int[] nums) {
        int len = nums.length;
        int rCounter = 0;
        int wCounter = 0;
        int bCounter = 0;
        for (int i=0; i<len; i++) {
            switch (nums[i]) {
                case '0' :
                    rCounter++;
                    break;
                case '1' :
                    wCounter++;
                    break;
                case '2' :
                    bCounter++;
                    break;
                default:
                    break;
            }
        }
        for (int i=0; i<len; i++) {
            if (i < rCounter) {
                nums[i] = 0;
            } else if(i < wCounter) {
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
        }
    }
}
