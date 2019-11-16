package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class _332_ReconstructItinerary {
	HashMap<String, PriorityQueue<String>> map;
	List<String> res;

	public List<String> findItinerary(String[][] tickets) {
		map = new HashMap<>();
		res = new LinkedList<>();
		for (String[] ticket : tickets) {
			map.computeIfAbsent(ticket[0], k -> new PriorityQueue<>()).add(ticket[1]);
		}
		helper("JFK");
		return res;
	}

	private void helper(String airport) {
		while (map.containsKey(airport) && !map.get(airport).isEmpty()) {
			helper(map.get(airport).poll());
		}
		res.add(0, airport);
	}
}
