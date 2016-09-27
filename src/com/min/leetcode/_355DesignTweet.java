package com.min.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class _355DesignTweet {

	List<Tweet> queue = new ArrayList<Tweet>();
	Map<Integer, LinkedList<Integer>> map = new HashMap<Integer, LinkedList<Integer>>();

	/** Initialize your data structure here. */
	public _355DesignTweet() {

	}

	/** Compose a new tweet. */
	public void postTweet(int userId, int tweetId) {
		Tweet t = new Tweet(userId, tweetId);
		queue.add(t);
	}

	/**
	 * Retrieve the 10 most recent tweet ids in the user's news feed. Each item
	 * in the news feed must be posted by users who the user followed or by the
	 * user herself. Tweets must be ordered from most recent to least recent.
	 */
	public List<Integer> getNewsFeed(int userId) {
		List<Integer> ids;
		List<Integer> res = new ArrayList<Integer>();
		if (map.containsKey(userId)) {
			ids = map.get(userId);
			ids.add(userId);
		} else {
			ids = new LinkedList<Integer>();
			ids.add(userId);
		}
		int i = 0;
		int idx = queue.size()-1;
		while (idx >=0 && i < 10) {
			Tweet t = queue.get(idx);
			if (ids.contains(t.userId)) {
				res.add(t.tweetId);
				i++;
			}
			idx--;
		}
		return res;
	}

	/**
	 * Follower follows a followee. If the operation is invalid, it should be a
	 * no-op.
	 */
	public void follow(int followerId, int followeeId) {
		if (map.containsKey(followerId)) {
			map.get(followerId).offer(followeeId);
		} else {
			LinkedList<Integer> list = new LinkedList<Integer>();
			list.add(followeeId);
			map.put(followerId, list);
		}
	}

	/**
	 * Follower unfollows a followee. If the operation is invalid, it should be
	 * a no-op.
	 */
	public void unfollow(int followerId, int followeeId) {
		if (map.containsKey(followerId)) {
			LinkedList<Integer> lst = map.get(followerId);
			for (int i = 0; i < lst.size(); i++) {
				if (lst.get(i) == followeeId) {
					lst.remove(i);
					map.put(followerId, lst);
				}
			}
		} else {
			return;
		}
	}
	public static void main(String[] args) {
		_355DesignTweet tw = new _355DesignTweet();
		tw.follow(2, 1);
		tw.postTweet(1, 0);
		tw.postTweet(1, 1);
		tw.postTweet(1, 2);
		tw.postTweet(1, 3);
		tw.unfollow(2, 1);
		System.out.println(tw.getNewsFeed(2));
	}

}

class Tweet {
	int userId;
	int tweetId;

	public Tweet(int userId, int tweetId) {
		this.userId = userId;
		this.tweetId = tweetId;
	}
}
