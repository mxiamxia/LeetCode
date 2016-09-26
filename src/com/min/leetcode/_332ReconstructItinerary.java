package com.min.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class _332ReconstructItinerary {
	
	/*
	 * Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.

Note:
If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
All airports are represented by three capital letters (IATA code).
You may assume all tickets form at least one valid itinerary.
Example 1:
tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
Return ["JFK", "MUC", "LHR", "SFO", "SJC"].
Example 2:
tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
Return ["JFK","ATL","JFK","SFO","ATL","SFO"].
Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"]. But it is larger in lexical order.

Solution,
PriorityQueue should be used instead of TreeSet, because there are duplicate entries.
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<String> findItinerary(String[][] tickets) {
        List<String> res = new ArrayList<String>();
        Map<String, PriorityQueue<String>> map = new HashMap<String, PriorityQueue<String>>();
        for (int i=0; i<tickets.length; i++) {
        	if (map.containsKey(tickets[i][0])) {
        		map.get(tickets[i][0]).add(tickets[i][1]);
        	} else {
        		PriorityQueue<String> q = new PriorityQueue<String>();
        		q.add(tickets[i][1]);
        		map.put(tickets[i][0], q);
        	}
        }
        dfs("JFK", res, map);
        return res;
    }

	private void dfs(String string, List<String> res, Map<String, PriorityQueue<String>> map) {
		// TODO Auto-generated method stub
		PriorityQueue<String> q = map.get(string);
		while (q != null && q.size() > 0) {
			dfs(q.poll(), res, map);
		}
		res.add(0, string); // recursive, add the top the the first
	}

}
