package com.leetcode.DFS;

public class ValidSudoku_Leetcode36 {
	public boolean isValidSudoku(char[][] board) {
		for (int row = 0; row < board.length; row++)
			for (int col = 0; col < board[0].length; col++) {
				if (board[row][col] == '.') continue;
				if (!valid(board, row ,col))
					return false;
			}
		return true;
	}

	private boolean valid(char[][] board, int i, int j) {
		for (int row = 0; row < board.length; row++){
			if (row == i) continue;
			if (board[row][j] == board[i][j]) return false;
		}

		for (int col = 0; col < board[0].length; col++){
			if (col == j) continue;
			if (board[i][col] == board[i][j]) return false;
		}

		for (int row = (i / 3) * 3; row < (i / 3 + 1) * 3; row++)
			for (int col = (j / 3) * 3; col < (j / 3 + 1) * 3; col++) {
				if (row == i && col == j) continue;
				if (board[row][col] == board[i][j])
					return false;
			}
			return true;
	}

}
