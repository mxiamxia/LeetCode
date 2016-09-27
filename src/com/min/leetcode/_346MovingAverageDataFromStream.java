package com.min.leetcode;

import java.util.LinkedList;

public class _346MovingAverageDataFromStream {
	
	/*
	 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

			For example,
			MovingAverage m = new MovingAverage(3);
			m.next(1) = 1
			m.next(10) = (1 + 10) / 2
			m.next(3) = (1 + 10 + 3) / 3
			m.next(5) = (10 + 3 + 5) / 3
			
			Solution,
			Use Queue to remove the first number
	 * 
	 */

	LinkedList<Integer> queue;
	int size;
	double avg;

	/** Initialize your data structure here. */
	public _346MovingAverageDataFromStream(int size) {
		this.queue = new LinkedList<Integer>();
		this.size = size;
	}

	public double next(int val) {
		if (queue.size() < this.size) {
			queue.offer(val);
			int sum = 0;
			for (int i : queue) {
				sum += i;
			}
			avg = (double) sum / queue.size();

			return avg;
		} else {
			int head = queue.poll();
			double minus = (double) head / this.size;
			queue.offer(val);
			double add = (double) val / this.size;
			avg = avg + add - minus;
			return avg;
		}
	}

}
