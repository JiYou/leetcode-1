package leetcode;

import java.util.HashSet;

public class _694_NumOfDistinctIslands {
	private int m;
	private int n;

	public int numDistinctIslands(int[][] grid) {
		m = grid.length;
		if (m == 0)
			return 0;
		n = grid[0].length;

		HashSet<String> set = new HashSet<>();
		boolean[][] visited = new boolean[m][n];
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == '1') {
					StringBuffer sb = new StringBuffer();
					dfs(grid, i, j, i, j, visited, sb);
					if (sb.length() > 0)
						set.add(sb.toString());
				}
			}
		return set.size();
	}

	private void dfs(int[][] grid, int i, int j, int oi, int oj, boolean[][] visited,  StringBuffer sb) {
		if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || grid[i][j] == '0')
			return;
		visited[i][j] = true;
		sb.append(i - oi).append("_").append(j - oj).append("_");
		dfs(grid, i - 1, j, oi, oj, visited, sb);
		dfs(grid, i + 1, j, oi, oj, visited, sb);
		dfs(grid, i, j + 1, oi, oj, visited, sb);
		dfs(grid, i , j - 1, oi, oj, visited, sb);
	}
}
