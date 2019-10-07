package com.leetcode.DFS;

public class SurroundedRegions_130 {

	private int n;
	private int m;
	public void solve(char[][] board) {
		if (board == null || board.length == 0 || board[0].length == 0)
			return;
		m = board.length;
		n = board[0].length;

		for (int i = 0; i < m; i++) {
			dfs(board, i, 0);
			dfs(board, i, n - 1);
		}

		for (int i = 0; i < n; i++) {
			dfs(board, 0, i);
			dfs(board, m - 1, i);
		}

		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				if (board[i][j] == '#')
					board[i][j] = 'o';
				else if (board[i][j] == 'o')
					board[i][j] = 'x';
	}

	private void dfs(char[][] board, int i, int j) {
		if (i < 0 || i > m || j < 0 || j > n || board[i][j] != 'o')
			return;
		board[i][j] = '#';
		dfs(board, i, j + 1);
		dfs(board, i, j - 1);
		dfs(board, i + 1, j);
		dfs(board, i - 1, j);
	}
}
