package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _797_AllPathsSourceTarget {
	private int n;
	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		List<List<Integer>> g = new ArrayList<>();
		for (int i = 0; i < graph.length; i++) {
			g.add(i, new ArrayList<>());
			for (int j = 0; j < graph[i].length; j++)
				g.get(i).add(graph[i][j]);
		}
		List<List<Integer>> res = new ArrayList<>();
		dfs(res, new ArrayList<>(), new boolean[n], 0, g);
		return res;
	}

	private void dfs(List<List<Integer>> res, List<Integer> list, boolean[] visited, int pos, List<List<Integer>> graph) {
		if (list.size() == n - 1) {
			res.add(new ArrayList<>(list));
			return;
		}

		list.add(pos);
		visited[pos] = true;

		for (int nei : graph.get(pos))
			if (!visited[nei]) {
				dfs(res, list, visited, nei, graph);
			}

		list.remove(list.size() - 1);
		visited[pos] = false;
	}
}
