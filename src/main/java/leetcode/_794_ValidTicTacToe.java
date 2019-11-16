package leetcode;

public class _794_ValidTicTacToe {
	public boolean validTicTacToe(char[][] board) {
		boolean xwin = false, owin = false;
		int[]rows = new int[board.length];
		int[] cols = new int[board[0].length];
		int diag = 0, antidiag = 0, turns = 0;

		for (int i = 0; i < board.length; i++)
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 'X') {
					rows[i]++;
					cols[j]++;
					turns++;
					if (i == j) diag++;
					if (i + j == 2) antidiag++;
				} else if (board[i][j] == 'O') {
					rows[i]--;
					cols[j]--;
					turns--;
					if (i == j) diag--;
					if (i + j == 2)
						antidiag--;
				}
			}

		xwin = rows[0] == 3 || rows[1] == 3 || rows[2] == 3 || cols[0] == 3 || cols[1] == 3 || cols[2] == 3 || diag == 3 || antidiag == 3;
		owin = rows[0] == -3 || rows[1] == -3 || rows[2] == -3 || cols[0] == -3 || cols[1] == -3 || cols[2] == -3 || diag == -3 || antidiag == -3;

		if ((xwin && turns == 0) || (owin && turns == 1))
			return false;
		return (turns == 0 || turns == 1) && (xwin || owin);
	}
}
