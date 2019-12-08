package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class _787_FindCheapestPrice {
	class Node {
		int city;
		int cost;
		int stop;
		public Node(int city, int cost, int stop) {
			this.city = city;
			this.cost = cost;
			this.stop = stop;
		}
	}

	public int findCheapestPrice(int n, int[][]fights, int src, int dst, int K) {
		if (n == 0 || K < 0 || fights == null || fights.length == 0 || fights[0].length == 0)
			return -1;

		int res = Integer.MAX_VALUE;
		HashMap<Integer, List<int []>> graph = new HashMap<>();
		for (int[] f : fights) {
			if (!graph.containsKey(f[0]))
				graph.put(f[0], new ArrayList<>());
			graph.get(f[0]).add(new int[] {f[1], f[2]});
		}

		PriorityQueue<Node> queue = new PriorityQueue<>( (a, b) ->(a.cost - b.cost));
		queue.add(new Node(src, 0, -1));
		while (!queue.isEmpty()) {
			Node cur = queue.poll();

			if (cur.city == dst)
				return cur.cost;

			if (cur.stop < K) {
				List<int[]> nexts = graph.getOrDefault(cur.city, new ArrayList<>());
				for (int[] next : nexts)
					queue.offer(new Node(next[0], cur.cost + next[1], cur.stop + 1));
			}
		}
		return -1;
	}
}
