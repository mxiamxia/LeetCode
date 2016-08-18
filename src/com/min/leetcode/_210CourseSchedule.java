package com.min.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _210CourseSchedule {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(findOrder(2, new int[][]{{0,1}}).toString());
	}
	public static int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) {
            return new int[0];
        }
        if(prerequisites.length == 0){
            int[] res = new int[numCourses];
            for(int m=0; m<numCourses; m++){
                res[m]=m;
            }
            return res;
        }
        List<Integer> list = new ArrayList<Integer>();
        int[] pCourses = new int[numCourses];
        int len = prerequisites.length;
        for (int i=0; i<len; i++) {
            pCourses[prerequisites[i][0]]++;
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i=0; i<numCourses; i++) {
            if (pCourses[i] == 0) {
                list.add(i);
                queue.add(i);
            }
        }
        int numCore = queue.size();
        while (queue.size() > 0) {
            int top = queue.poll();
            for (int i=0; i<len; i++) {
                if(prerequisites[i][1] == top) {
                    pCourses[prerequisites[i][0]]--;
                    if (pCourses[prerequisites[i][0]] == 0) {
                        list.add(prerequisites[i][0]);
                        queue.add(prerequisites[i][0]);
                        numCore++;
                    }
                }
            }
        }
        if (numCore == numCourses) {
            int[] res = new int[list.size()];
            for(int i=0; i<list.size(); i++) {
                res[i] = list.get(i);
            }
            return res;
        } else {
            return new int[0]; 
        }
        
    }

}
