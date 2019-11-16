package leetcode;

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


}
