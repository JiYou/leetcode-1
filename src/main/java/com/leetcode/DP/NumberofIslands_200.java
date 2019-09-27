package com.leetcode.DP;

import java.util.LinkedList;
import java.util.Queue;

public class NumberofIslands_200 {
	private int m;
	private int n;

	public int numIsLands(char[][] grid) {
		if (grid == null || grid.length == 0)
			return 0;
		m = grid.length;
		n = grid[0].length;
		int res = 0;

		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == '1') {
					dfs(grid, i, j);
					res++;
				}
			}

		return res;
	}

	private void dfs(char[][] grid, int i, int j) {
		if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == '0')
			return;
		grid[i][j] = '0';
		dfs(grid, i, j + 1);
		dfs(grid, i, j - 1);
		dfs(grid, i + 1, j);
		dfs(grid, i - 1, j);
	}

	public int numIsLands2(char[][] grid) {
		if (grid == null || grid.length == 0)
			return 0;
		int res = 0;
		for (int i = 0; i < grid.length; i++)
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1') {
					bfs(grid, i, j);
					res++;
				}
			}
		return res;
	}

	private void bfs(char[][] grid, int i, int j) {
		grid[i][j] = '0';
		int row = grid.length;
		int col = grid[0].length;
		Queue<Integer> queue = new LinkedList<>();
		int code = i * col + j;
		queue.offer(code);

		while (!queue.isEmpty()) {
			code = queue.poll();
			int x = code / col;
			int y = code % col;
			if (x > 0 && grid[x - 1][y] == '1') {
				queue.offer((x - 1) * col + y);
				grid[x - 1][y] = '0';
			}
			if (x < col - 1 && grid[x + 1][y] == '1') {
				queue.offer((x + 1) * col + y);
				grid[x + 1][y] = '0';
			}
			if (y > 0 && grid[x][y - 1] == '1') {
				queue.offer(x * col + y - 1);
				grid[x][y - 1] = '0';
			}
			if (y < row - 1 && grid[x][y + 1] == '1') {
				queue.offer(x * col + y + 1);
				grid[x][y + 1] = '0';
			}
		}
	}
}
