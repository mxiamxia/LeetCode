package com.min.leetcode;

public class _376WiggleMaxLength {
/**	
	A sequence of numbers is called a wiggle sequence if the differences between successive numbers strictly alternate between positive and negative. The first difference (if one exists) may be either positive or negative. A sequence with fewer than two elements is trivially a wiggle sequence.

	For example, [1,7,4,9,2,5] is a wiggle sequence because the differences (6,-3,5,-7,3) are alternately positive and negative. In contrast, [1,4,7,2,5] and [1,7,4,5,5] are not wiggle sequences, the first because its first two differences are positive and the second because its last difference is zero.

	Given a sequence of integers, return the length of the longest subsequence that is a wiggle sequence. A subsequence is obtained by deleting some number of elements (eventually, also zero) from the original sequence, leaving the remaining elements in their original order.

	Examples:
	Input: [1,7,4,9,2,5]
	Output: 6
	The entire sequence is a wiggle sequence.

	Input: [1,17,5,10,13,15,10,5,16,8]
	Output: 7
	There are several subsequences that achieve this length. One is [1,17,10,13,10,16,8].

	Input: [1,2,3,4,5,6,7,8,9]
	Output: 2
*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] nums = {1,7,4,9,2,5};
		int[] nums = {1,17,5,10,13,15,10,5,16,8};
		System.out.println(wiggleMaxLength(nums));
	}
	
	public static int wiggleMaxLength(int[] nums) {
        if ( nums == null) {
            return 0;
        }
        if (nums.length <= 1) {
            return nums.length;
        }
        Boolean flag = null;
        int count = 1;
        for(int i=1; i<nums.length; i++) {
            if (nums[i] > nums[i-1]) {
                if (flag == null) {
                    count++;
                    flag = true;
                } else {
                    if (!flag) {
                        count++;
                        flag = true;
                    }
                }
            } else if (nums[i] < nums[i-1]) {
                if (flag == null) {
                    count++;
                    flag = false;
                } else {
                    if (flag) {
                        count++;
                        flag = false;
                    }
                }
            }
        }
        return count;
    }

	public static int wiggleMaxLengthInSequence(int[] nums) {
		int max = 0;
        int len = nums.length;
		if (nums == null || len == 0) {
			return max;
		}
		if (len == 1) {
		    return 1;
		}
		int index = 0;
		int wiggle = -1;
		int tmpMax = 0;
		while(index < len-1) {
		    int diff = nums[index+1] - nums[index];
		    int tmp;
		    if (diff > 0) {
		        tmp = 2;
		    } else if (diff < 0) {
		        tmp = 1;
		    } else {
		        tmp = 0;
		    }
		    
		    if (tmp !=0 && tmp != wiggle) {
		        tmpMax++;
		        max = Math.max(max, tmpMax);
		        index++;
		    } else if (tmp == wiggle || tmp == 0) {
		        max = Math.max(max, tmpMax);
		        tmpMax = 0;
		        wiggle = -1;
		        continue;
		    }
		    wiggle = tmp;
		}
		return max + 1;
    }
}
