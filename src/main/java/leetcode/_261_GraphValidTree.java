package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class _261_GraphValidTree {
	public boolean validTree(int n, int[][] edges) {
		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < n; i++)
			graph.add(new ArrayList<>());
		for (int i = 0; i < edges.length; i++) {
			graph.get(edges[i][0]).add(edges[i][1]);
			graph.get(edges[i][1]).add(edges[i][0]);
		}
		HashSet<Integer> visited = new HashSet<>();
		visited.add(0);
		boolean res = dfs(graph, visited, 0, -1);
		if (res == false) return false;
		return visited.size() == n ? true: false;
	}

	private boolean dfs(List<List<Integer>> graph, HashSet<Integer> visited, int node, int parent) {
		List<Integer> sub = graph.get(node);
		for (int v : sub) {
			if (v == parent) continue;
			if (visited.contains(v)) return false;
			visited.add(v);
			boolean res = dfs(graph, visited, v, node);
			if (res == false) return false;
		}
		return true;
	}

	public boolean validTree2(int n, int[][] edges) {
		if (n == 1 && edges.length == 0) return true;
		if (n < 1 || edges == null || edges.length < n - 1) return false;

		int[] roots = new int[n];
		for (int i = 0; i < n; i++)
			roots[i] = -1;

		for (int[] pair : edges) {
			int x = find(roots, pair[0]);
			int y = find(roots, pair[1]);
			if (x == y) return false;
			roots[x] = y;
		}
		return true;
	}

	private int find(int[] roots, int i) {
		while (roots[i] != -1) {
			i = roots[i];
		}
		return i;
	}

	int connect = 0;

	public boolean validTree3(int n, int[][] edges) {
		if (edges == null || edges.length != n -1)
			return false;
		List<List<Integer>> graph = new ArrayList<List<Integer>>();
		for (int i = 0; i < n; i++)
			graph.add(new ArrayList<Integer>());

		for (int[] edge : edges) {
			graph.get(edge[0]).add(edge[1]);
			graph.get(edge[1]).add(edge[0]);
		}

		boolean[] visited = new boolean[n];
		valid(graph, 0, visited);
		return connect == n;
	}

	private void valid(List<List<Integer>> graph, int v, boolean[] visited) {
		if (visited[v])
			return;
		connect++;
		visited[v] = true;
		for (int n : graph.get(v))
			valid(graph, n, visited);
	}


	//DFS

	public boolean validTree4(int n, int[][] edges) {
		if (edges == null || edges.length != n -1)
			return false;

		int[][] graph = new int[n][n];
		for (int[] edge : edges) {
			graph[edge[0]][edge[1]] = 1;
			graph[edge[1]][edge[0]] = 1;
		}

		Stack<Integer> stack = new Stack<Integer>();
		stack.add(0);
		boolean[] visited = new boolean[n];
		while (!stack.isEmpty()) {
			Integer cur = stack.pop();
			visited[cur] = true;
			for (int i = 0; i < n; i++) {
				if (graph[cur][i] == 1) {
					if (visited[i])
						return false;
					visited[i] = true;
					graph[cur][i] = 0;
					graph[i][cur] = 0;
					stack.add(i);
				}
			}
		}
		for (int i = 0; i < n; i++)
			if (!visited[i])
				return false;
		return true;
	}
}
