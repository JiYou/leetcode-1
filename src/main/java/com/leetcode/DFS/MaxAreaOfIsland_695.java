package com.leetcode.DFS;

public class MaxAreaOfIsland_695 {
	private int m;
	private int n;

	public int maxAreaOfIsland(int[][] grid) {
		m = grid.length;
		if (m == 0) return 0;
		n = grid[0].length;
		int res = 0;
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					int cnt = 0;
					dfs(grid, i , j, 0);
				}

			}
		return res;
	}

	private int dfs(int[][] grid, int i, int j, int cnt) {
		if (i < 0 || i > m || j < 0 || j > n || grid[i][j] <= 0)
			return 0;
		grid[i][j] = -1;
		int res = 1;
		res += dfs(grid, i, j + 1, cnt);
		res += dfs(grid, i, j - 1, cnt);
		res += dfs(grid, i + 1, j, cnt);
		res += dfs(grid, i - 1, j, cnt);
		return res;
	}
}
