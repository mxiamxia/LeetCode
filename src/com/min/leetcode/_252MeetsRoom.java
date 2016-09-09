package com.min.leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class _252MeetsRoom {
	/*
	 * Given an array of meeting time intervals consisting of start and end
	 * times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend
	 * all meetings.
	 * 
	 * For example, Given [[0, 30],[5, 10],[15, 20]], return false.
	 * 
	 * 这题和Merge
	 * Intervals很像，我们按开始时间把这些Interval都给排序后，就挨个检查是否有冲突就行了。有冲突的定义是开始时间小于之前最晚的结束时间。
	 * 这里之前最晚的结束时间不一定是上一个的结束时间，所以我们更新的时候要取最大值。
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_252MeetsRoom in = new _252MeetsRoom();
		Interval i1 = new Interval(0, 30);
		Interval i2 = new Interval(5, 10);
		Interval i3 = new Interval(15, 20);
		Interval[] i = new Interval[] { i1, i3, i2 };
		in.canAttendMeetings(i);
	}

	public boolean canAttendMeetings(Interval[] intervals) {
		if (intervals == null || intervals.length == 0) {
			return false;
		}
		if (intervals.length == 1) {
			return true;
		}
		Arrays.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				// TODO Auto-generated method stub
				return o1.start - o2.start;
			}
		});
		int end = intervals[0].end;
		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i].start < end) {
				return false;
			}
			// 如果Interval的开始时间小于之前最晚的结束时间，就返回假
			end = Math.max(end, intervals[i].end);
		}
		return true;
	}

	static class Interval {
		int start;
		int end;

		public Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

}
