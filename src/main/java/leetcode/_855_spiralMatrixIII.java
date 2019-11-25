package leetcode;

public class _855_spiralMatrixIII {
	public int[][] spiralMatrix(int R, int C, int r0, int c0) {
		int[] dr = new int[] {0, 1, 0, -1};
		int[] dc = new int[] {1, 0, -1, 0};

		int[][] ans = new int[R*C][2];
		int t = 0;
		ans[t++] = new int[]{r0, c0};
		if (R*C == 1)
			return ans;

		int step = 0, cur = 0;

		while (ans.length < R*C) {
			if (cur == 0 || cur == 2)
				step++;
			for (int i = 0; i < step; i++) {
				r0 += dr[cur];
				c0 += dc[cur];
				if (r0 >= 0 && r0 < R && c0 >= 0 && c0 < C)
					ans[t++] = new int[] {r0, c0};
			}
			cur = (cur + 1) % 4;
		}
		return ans;
	}

	public int[][] spiralMatrix2(int R, int C, int r0, int c0) {
		int[][] ans = new int[R*C][2];
		int step = 1;
		int t = 0;
		ans[t++] = new int[]{r0, c0};
		while (ans.length < R * C) {
			for (int i = 0; i < step; i++)
				add(R, C, r0, c0++, ans, t++);
			for (int i = 0; i < step; i++)
				add(R, C, r0++, c0, ans, t++);
			step++;
			for (int i = 0; i < step; i++)
				add(R, C, r0, c0--, ans, t++);
			for (int i = 0; i < step; i++)
				add(R, C, r0--, c0, ans, t++);
			step++;
		}
		return ans;
	}

	private void add(int R, int C, int r0, int c0, int[][] ans, int t) {
		if (r0 >= 0 && r0 < R && c0 >= 0 && c0 < C)
			ans[t++] = new int[] {r0, c0};
	}

}
