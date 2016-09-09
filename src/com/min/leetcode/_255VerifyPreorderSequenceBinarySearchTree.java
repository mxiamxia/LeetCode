package com.min.leetcode;

import java.util.Stack;

public class _255VerifyPreorderSequenceBinarySearchTree {

	/*
	 * 
	 * Given an array of numbers, verify whether it is the correct preorder
	 * traversal sequence of a binary search tree.
	 * 
	 * You may assume each number in the sequence is unique.
	 * 
	 * Follow up: Could you do it using only constant space complexity?
	 * 
	 * 
	 * 二叉搜索树先序遍历序列的特点是降序的部分一定是向左走的，一旦开始升序说明开始向右走了，则上一个降序的点则限定了后面的数的最小值。如果继续降序，
	 * 说明又向左走了，这样等到下次向右走得时候也要再次更新最小值。
	 * 
	 *     10
		   /  \
		  5    12
		 / \
		2   6
	 * 如这个例子，我们在10的位置是没有最小值限定的，然后降序走到5，依然没有最小值，降序走到2，依然没有，然后开始升序了，遇到6，
	 * 这时候之后的数字一定大于2，同时也大于5，所以最小值更新为之前遍历过的，且比当前数稍微小一点的那个数。这里我们可以用一个栈来暂存之前的路径，
	 * 所以升序时就是将栈中元素不断pop出来直到栈顶大于当前数，而最小值就是最后一个pop出来的数，最后再把该数push进去。对于降序的时候，
	 * 直接向里面push就行了。这样，序列无效的条件就是违反了这个最小值的限定。
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_255VerifyPreorderSequenceBinarySearchTree in = new _255VerifyPreorderSequenceBinarySearchTree();
		int[] preorder = new int[]{10, 5, 2, 6, 12};
		int[] postorder = new int[]{2,6,5,12,10};
		in.verifyPreorder(preorder);
		in.IsValidPostOrderBst(postorder);
	}

	public boolean verifyPreorder(int[] preorder) {
		int min = Integer.MIN_VALUE;
		Stack<Integer> stack = new Stack<Integer>();
		for (int i=0; i<preorder.length; i++) {
			if (preorder[i] < min) {
				return false;
			}
			while (!stack.isEmpty() && stack.peek() < preorder[i]) {
				stack.pop();
				min = preorder[i];
			}
			stack.push(preorder[i]);
		}
		return true;
	}
	
	//	Q：如何验证后序序列？
	//	A：后序序列的顺序是left - right - root，而先序的顺序是root - left - right。我们同样可以用本题的方法解，不过是从数组的后面向前面遍历，因为root在后面了。而且因为从后往前看是先遇到right再遇到left，所以我们要记录的是限定的最大值，而不再是最小值，栈pop的条件也变成pop所有比当前数大得数。栈的增长方向也是从高向低了。

	    public boolean IsValidPostOrderBst(int[] nums)
	    {
	        int i = nums.length;
	        int max = Integer.MAX_VALUE;
	        for (int j = nums.length - 1; j >= 0; j--)
	        {
	            if (nums[j] > max) return false;
	            while (i <= nums.length - 1 && nums[j] > nums[i])
	                max = nums[i++];
	            nums[--i] = nums[j];
	        }
	        return true;
	    }

}
