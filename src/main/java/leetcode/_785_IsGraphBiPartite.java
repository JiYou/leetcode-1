package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class _785_IsGraphBiPartite {

	private int[] roots;

	public boolean isBipartite(int[][] graph) {
		int len = graph.length;
		int[] colors = new int[len];
		for (int i = 0; i < len; i++) {
			if (colors[i] == 0) {
				if (!bfs(graph, colors, 1, i))
					return false;
			}
		}
		return true;
	}

	private boolean bfs(int[][] graph, int[] colors, int color, int node) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(node);
		colors[node] = color;

		while (!queue.isEmpty()) {
			int cur = queue.poll();
			int col = colors[cur];
			for (int next : graph[cur]) {
				if (colors[next] == 0) {
					queue.offer(next);
					colors[next] = -col;
				} else {
					if (colors[next] == col)
						return false;
				}
			}
		}
		return true;
	}

	public boolean isBipartite2(int[][] graph) {
		roots = new int[graph.length];
		for (int i = 0; i < graph.length; i++)
			roots[i] = i;
		for (int i = 0; i < graph.length; i++) {
			if (graph[i].length <= 0) continue;
			int x = find(i);
			int y = find(graph[i][0]);
			if (x == y) return false;
			for (int j = 1; j < graph[i].length; j++) {
				int parent = find(graph[i][j]);
				if (x == parent)
					return false;
				roots[parent] = y;
			}
		}
		return true;
	}

	private int find(int x) {
		return x == roots[x] ? x : find(roots[x]);
	}
}
