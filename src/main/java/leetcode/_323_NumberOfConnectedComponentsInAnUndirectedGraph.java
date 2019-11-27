package leetcode;

import java.util.*;

public class _323_NumberOfConnectedComponentsInAnUndirectedGraph {
	public int countComponents(int n, int[][] edges) {
		int res = n;
		int[] roots = new int[n];
		for (int i = 0; i < n; i++)
			roots[i] = -1;

		for (int[] pair : edges) {
			int x = find(roots, pair[0]);
			int y = find(roots, pair[1]);
			if (x != y) {
				roots[x] = y;
				res--;
			}
		}
		return res;
	}

	private int find(int[] roots, int i) {
		while (roots[i] != -1)
			i = roots[i];
		return i;
	}

	public int countComponents2(int n, int[][] edges) {
		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < n; i++)
			graph.add(new ArrayList<>());

		for (int[] pair : edges) {
			graph.get(pair[0]).add(pair[1]);
			graph.get(pair[1]).add(pair[0]);
		}

		int count = 0;
		HashSet<Integer> visited = new HashSet<>();

		for (int i = 0; i < n; i++) {
			if (!visited.contains(i)) {
				dfs(graph, i, visited);
				count++;
			}
		}
		return count;
	}

	// dfs + recursion
	private void dfs(List<List<Integer>> graph, int node, HashSet<Integer> visited) {
		visited.add(node);
		for (int n : graph.get(node))
			if (!visited.contains(n))
				dfs(graph, n, visited);
	}

	//bfs + queue
	private void bfs(List<List<Integer>> graph, int node, HashSet<Integer> visited) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(node);
		visited.add(node);
		while (!queue.isEmpty()) {
			Integer cur = queue.poll();
			List<Integer> neighbours = graph.get(cur);
			for (int neighbour : neighbours)
				if (!visited.contains(neighbour)) {
					queue.offer(neighbour);
					visited.add(neighbour);
				}
		}
	}
}
