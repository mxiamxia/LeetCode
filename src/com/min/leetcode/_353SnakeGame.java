package com.min.leetcode;

import java.util.LinkedList;

public class _353SnakeGame {
	
	int index;
	int len;
	int width;
	int height;
	int x, y;
	int[][] food;
	LinkedList<int[]> queue;

	public _353SnakeGame(int width, int height, int[][] food) {
		this.index = 0;
		this.len = 0;
		this.width = width;
		this.height = height;
		this.food = food;
		queue = new LinkedList<int []>();
		this.queue.offer(new int[]{0, 0});
	}
	
	public int move(String direction) {
		switch (direction) {
			case "U" :
				x--;
				break;
			case "D" :
				x++;
				break;
			case "L" :
				y--;
				break;
			case "R" :
				y++;
				break;
		}
		if (!isValid(x, y)) {
			return -1;
		}
		return process(x, y);
	}

	private int process(int x, int y) {
		if (index == food.length) {
			queue.poll(); // if all food eaten, just move the snake. remove the tail 
		} else if (food[index][0] == x && food[index][1] == y) {
			len++;
			index++;
		} else {
			queue.poll();
		}
		for (int[] p : queue) {
			if (p[0] == x && p[1] == y) {   // hit the body
				return -1;
			}
		}
		this.queue.offer(new int[]{x, y});
		return len;
	}

	private boolean isValid(int x, int y) {
		if (x < 0 || x> height || y < 0 || y > width) {
			return false;
		}
		return true;
	}
}
