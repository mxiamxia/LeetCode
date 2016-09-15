package com.min.leetcode;

public class _286WallAndGates {
	
	/*
	 * You are given a m x n 2D grid initialized with these three possible values.

		-1 - A wall or an obstacle.
		0 - A gate.
		INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647. Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.
		For example, given the 2D grid:
		
		INF  -1  0  INF
		INF INF INF  -1
		INF  -1 INF  -1
		  0  -1 INF INF 
		After running your function, the 2D grid should be:
		
		  3  -1   0   1
		  2   2   1  -1
		  1  -1   2  -1
		  0  -1   3   4
		  
		  复杂度
			时间 O(NM) 空间 O(N)
			
			思路
			实际上就是找每个房间到最近的门的距离，我们从每个门开始，
			广度优先搜索并记录层数就行了。如果某个房间之前被标记过距离，
			那就选择这个距离和当前距离中较小的那个。这题要注意剪枝，如果下一步是门或者下一步是墙或者下一步已经访问过了，就不要加入队列中。否则会超时。


	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int INF = 2147483647;
		int[][] rooms = new int[][] {
			{INF,  -1,  0,  INF}, 
			{INF, INF, INF,  -1}, 
			{INF,  -1, INF,  -1}, 
			{0,    -1, INF, INF }};
			_286WallAndGates in = new _286WallAndGates();
			in.wallsAndGates(rooms);
			System.out.println(rooms);

	}
	
	public void wallsAndGates(int[][] rooms) {
		if (rooms.length == 0) {
			return;
		}
		for (int i=0; i<rooms.length; i++) {
			for (int j=0; j<rooms.length; j++) {
				if (rooms[i][j] == 0) {
					boolean[][] visisted = new boolean[rooms.length][rooms[0].length];
					bfs(i, j, rooms, 0, visisted);
				}
			}
		}
		
	}

	private void bfs(int i, int j, int[][] rooms, int steps, boolean[][] visisted) {
		if (i<0 || i>=rooms.length || j<0 || j >= rooms[0].length || visisted[i][j]) {
			return;
		} else {
			visisted[i][j] = true;
		}
		if (steps == 0) {
			bfs(i-1, j, rooms, steps+1, visisted); //up
			bfs(i, j-1, rooms, steps+1, visisted); //left
			bfs(i, j+1, rooms, steps+1, visisted); //right
			bfs(i+1, j, rooms, steps+1, visisted); //down
		} else if (i>=0 && i<rooms.length && j>=0 && j < rooms[0].length && rooms[i][j] != 0 && rooms[i][j] != -1) {
			steps = Math.min(rooms[i][j], steps);
			rooms[i][j] = steps;
			bfs(i-1, j, rooms, steps+1, visisted); //up
			bfs(i, j-1, rooms, steps+1, visisted); //left
			bfs(i, j+1, rooms, steps+1, visisted); //right
			bfs(i+1, j, rooms, steps+1, visisted); //down
		}
	}

}
