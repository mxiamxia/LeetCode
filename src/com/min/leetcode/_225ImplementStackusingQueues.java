package com.min.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class _225ImplementStackusingQueues {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class MyStack {
		// Push element x onto stack.
		Queue<Integer> q1 = new LinkedList<Integer>();
		Queue<Integer> q2 = new LinkedList<Integer>();

		public void push(int x) {
			if (q1.isEmpty() && q2.isEmpty()) {
				q1.offer(x);
			} else if (q1.isEmpty()) {
				q2.offer(x);
			} else {
				q1.offer(x);
			}
		}

		// Removes the element on top of the stack.
		public void pop() {
			if (empty()) {
				return; // throw err
			}
			if (q1.isEmpty()) {
				while (!q2.isEmpty()) {
					int x = q2.poll();
					if (!q2.isEmpty()) {
						q1.offer(x);
					}
				}
			} else {
				while (!q1.isEmpty()) {
					int x = q1.poll();
					if (!q1.isEmpty()) {
						q2.offer(x);
					}
				}
			}
		}

		// Get the top element.
		public int top() {
			if (empty()) {
				return 0; // throw err
			}
			int x = 0;
			if (q1.isEmpty()) {
				while (!q2.isEmpty()) {
					x = q2.poll();
					q1.offer(x);
				}
			} else {
				while (!q1.isEmpty()) {
					x = q1.poll();
					q2.offer(x);
				}
			}
			return x;
		}

		// Return whether the stack is empty.
		public boolean empty() {
			if (q1.isEmpty() && q2.isEmpty()) {
				return true;
			}
			return false;
		}
	}

}
