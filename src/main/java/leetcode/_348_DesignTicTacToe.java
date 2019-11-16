package leetcode;

public class _348_DesignTicTacToe {
	private int[] rows;
	private int[] cols;
	private int diagonal;
	private int antiDiagonal;
	private int size;

	public _348_DesignTicTacToe(int n) {
		rows = new int[n];
		cols = new int[n];
		size = n;
	}

	public int move(int row, int col, int player) {
		int add = player == 1 ? 1 : -1;
		rows[row] += add;
		cols[col] += add;

		if (row == col)
			diagonal += add;
		if (row + col == cols.length - 1)
			antiDiagonal += add;

		if (Math.abs(rows[row]) == size || Math.abs(cols[col]) == size ||
		Math.abs(diagonal) == size || Math.abs(antiDiagonal) == size)
			return player;
		return 0;
	}
}
