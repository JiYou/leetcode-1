package com.leetcode.misc;

public class GameofLife_289 {
	public void gameOfLife(int[][] board) {
		for (int i = 0; i < board.length; i++)
			for (int j = 0; j < board[0].length; j++)
				board[i][j] = checkAndMark(board, i, j);

		for (int i = 0; i < board.length; i++)
			for (int j = 0; j < board[0].length; j++)
				board[i][j] = board[i][j] == 1 || board[i][j] == -2 ? 1 : 0;
	}



	private int checkAndMark(int[][] board, int i, int j) {
		int count = 0;
		int l = Math.max(j - 1, 0);
		int r = Math.min(j + 1, board[i].length - 1);
		int u = Math.max(i - 1, 0);
		int d = Math.min(i + 1, board.length - 1);

		for (int x = u; x <= d; x++)
			for (int y = l; y <= r; y++)
				count = board[x][y] == 1 ? count + 1: count;
		return board[i][j] == 1 ? (count == 2 || count == 3 ? 1 : -1) : (count == 3 ? -2 : 0);
	}
}
