package leetcode;

public class _470_Rand10 {
	public int rand10() {
		int row, col, idx = 41;
		while (idx > 40) {
			row = rand7();
			col = rand7();
			idx = col + (row - 1) * 7;
		}
		return 1 + (idx - 1) % 10;
	}

	private int rand7() {
		return 1;
	}
}
