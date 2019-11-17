package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _886_PossibleBipartition {
	public boolean possibleBipartition(int n, int[][] dislikes) {
		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < dislikes.length; i++)
			graph.add(new ArrayList<>());
		for (int[] a : dislikes) {
			graph.get(a[0]).add(a[1]);
			graph.get(a[1]).get(a[0]);
		}

		int[] colors = new int[n + 1];

		for (int i = 1; i <=n; i++) {
			if (colors[i] == 0) {
				if (!possibleBipartition(graph, colors, 1, i));
				return false;
			}
		}

		return true;

	}

	public boolean possibleBipartition(List<List<Integer>> graph, int[] colors, int color, int node) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(node);
		colors[node] = color;

		while (!queue.isEmpty()) {
			int cur = queue.poll();
			int col = colors[cur];
			for (int next : graph.get(cur)) {
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

}
