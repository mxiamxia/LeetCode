package com.min.leetcode;

import java.util.Collections;
import java.util.PriorityQueue;

public class _295FindMedianfromDataStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_295FindMedianfromDataStream in = new _295FindMedianfromDataStream();
		in.addNum(1768);in.findMedian();in.addNum(3181);in.findMedian();in.addNum(2366);in.findMedian();in.addNum(3696);in.findMedian();in.addNum(13344);in.findMedian();
	}
	PriorityQueue<Integer> maxheap = new PriorityQueue<Integer>();
    PriorityQueue<Integer> minheap = new PriorityQueue<Integer>(Collections.reverseOrder());
    
    // Adds a number into the data structure.
    public void addNum(int num) {
        maxheap.offer(num);
        minheap.offer(maxheap.poll());
        if(maxheap.size() < minheap.size()){
            maxheap.offer(minheap.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        return maxheap.size() == minheap.size() ? (double)(maxheap.peek() + minheap.peek()) / 2.0 : maxheap.peek();
    }

}
