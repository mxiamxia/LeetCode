package com.min.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class _207CourseSchedule {

	/*
	 * There are a total of n courses you have to take, labeled from 0 to n - 1.
	 * 
	 * Some courses may have prerequisites, for example to take course 0 you
	 * have to first take course 1, which is expressed as a pair: [0,1]
	 * 
	 * Given the total number of courses and a list of prerequisite pairs, is it
	 * possible for you to finish all courses?
	 * 
	 * For example:
	 * 
	 * 2, [[1,0]] There are a total of 2 courses to take. To take course 1 you
	 * should have finished course 0. So it is possible.
	 * 
	 * 2, [[1,0],[0,1]] There are a total of 2 courses to take. To take course 1
	 * you should have finished course 0, and to take course 0 you should also
	 * have finished course 1. So it is impossible.
	 * 
	 * 
	 */
	
	public static void main(String[] args) {
		try {
			System.out.print(canFinish1(3, new int[][]{{1,0},{2,1}}));
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null) {
            return false;
        }
        int len = prerequisites.length;
        if (numCourses <= 0 || len == 0) {
            return true;
        }
        int[] pCourse = new int[numCourses];
        // record how many prerequisite for each course
        for(int i=0; i<len; i++) {
            pCourse[prerequisites[i][0]]++;             
        }
        //record the course without prerequisites
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int j=0; j<numCourses; j++) {
            if(pCourse[j] == 0) {
                queue.add(j);
            }
        }
        //existing courses without pre
        int numNoPre = queue.size();
        while (queue.size() > 0) {
            int top = queue.poll();
            for(int k=0; k<len; k++) {
                if (prerequisites[k][1] == top) {
                    pCourse[prerequisites[k][0]]--; //remove one pre for each course
                    if (pCourse[prerequisites[k][0]] == 0) {
                        numNoPre++;
                        queue.add(prerequisites[k][0]);
                    }
                }
            }
        }
        return numNoPre == numCourses;
    }
	
	public static boolean canFinish1(int numCourses, int[][] prerequisites) {
        if (prerequisites == null) {
            return false;
        }
        int[] preCourse = new int[numCourses];
        for (int i=0; i<prerequisites.length; i++) {
            preCourse[prerequisites[i][0]]++;
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i=0; i<preCourse.length; i++) {
            if (preCourse[i] == 0) {
                queue.add(i);
            }
        }
        int numResolved = queue.size();
        while (queue.size() > 0) {
            int top = queue.poll();
            for (int i=0; i<prerequisites.length; i++) {
                if (prerequisites[i][1] == top) {
                    preCourse[prerequisites[i][0]]--;
                    if (preCourse[prerequisites[i][0]] == 0) {
                        queue.add(prerequisites[i][0]);
                        numResolved++;
                    }
                }
            }
        }
        return numResolved == numCourses;
    }
}
