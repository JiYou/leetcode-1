package com.leetcode.design;

/**
 * Created by lhcxx on 18/10/26.
 */
public class DesignTicTacToe_Leetcode348 {
	private int n;
	private int[] rows;
	private int[] cols;
	private int diag;
	private int antiDiag;

	public DesignTicTacToe_Leetcode348(int n) {
		this.n = n;
		rows = new int[n];
		cols = new int[n];
		diag = 0;
		antiDiag = 0;
	}

	public int move(int row, int col, int player) {
		int flag = (player == 1 ? 1 : -1);

		rows[row] += flag;
		cols[col] += flag;
		if (row == col)
			diag += flag;
		if (row + col == n - 1)
			antiDiag += flag;
		if (Math.abs(rows[row]) == n || Math.abs(cols[col]) == n || Math.abs(diag) == n || Math.abs(antiDiag) == n)
			return player;
		return 0;
	}

}
