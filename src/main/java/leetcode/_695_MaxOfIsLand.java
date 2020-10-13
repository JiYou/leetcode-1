package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class _695_MaxOfIsLand {
	private int m;
	private int n;

	public int maxAreaOfIsland(int[][] grid) {
		m = grid.length;
		if (m ==0)
			return 0;
		n = grid[0].length;
		int res = 0;
		boolean[][] visited = new boolean[m][n];
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == '1') {
					res = Math.max(res, dfs(grid, i, j, visited));
				}
			}

		return res;
	}

	private int dfs(int[][]grid, int i, int j, boolean[][] visited) {
		if (i < 0 || i >= m || j < 0 || j >= 0 || grid[i][j] == '0' || visited[i][j])
			return 0;
		visited[i][j] = true;
		int res = 1;
		res += dfs(grid, i + 1, j, visited);
		res += dfs(grid, i - 1, j, visited);
		res += dfs(grid, i, j + 1, visited);
		res += dfs(grid, i, j - 1, visited);
		return res;
	}


	public int maxAreaOfIsland2(int[][] grid) {
		int max = 0;
		for (int i = 0; i < grid.length; i ++)
			for (int j = 0; j < grid[0].length; j++)
				if (grid[i][j] == 1)
					max = Math.max(max, dfs(grid, i, j));
		return max;
	}

	private int dfs(int[][] grid, int i, int j) {
		if (i < 0 || i > grid.length || j < 0 || j > grid[0].length || grid[i][j] == 0)
			return 0;
		grid[i][j] = 0;
		return 1 + dfs(grid, i + 1, j) + dfs(grid, i - 1, j) + dfs(grid, i, j + 1) + dfs(grid, i, j - 1);
	}

	private int bfs(int[][] grid, int i, int j) {
		int m = grid.length, n = grid[0].length;
		if (grid[i][j] == 0)
			return 0;
		grid[i][j] = 0;
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {i, j});
		int[][] dir = new int[][] {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
		int res = 1;
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			for (int[] d : dir) {
				int x = cur[0] + d[0];
				int y = cur[1] + d[1];
				if(x < 0 || x > m || y < 0 || y > n || grid[x][y] == 0)
					continue;
				grid[x][y] = 0;
				res++;
				queue.offer(new int[] {x,y});
			}
		}
		return res;
	}
}
