package leetcode;

public class _562_LongestLineInMatrix {
	public int longestLine(int[][] M) {
		int res = 0, count = 0;
		if (M.length == 0)
			return res;

		for (int i = 0; i < M.length; i++) {
			count = 0;
			for (int j = 0; j < M[0].length; j++) {
				if (M[i][j] == 1) {
					count++;
					res = Math.max(res, count);
				} else
					count = 0;
			}
		}

		for (int i = 0; i < M[0].length; i++) {
			count = 0;
			for (int j = 0; j < M.length; j++) {
				if (M[j][i] == 1) {
					count++;
					res = Math.max(res, count);
				} else
					count = 0;
			}
		}

		for (int i = 0; i < M.length; i++) {
			count = 0;
			for (int j = 0, k = i; j < M[0].length && k < M.length; j++, k++) {
				if (M[k][j] == 1) {
					count++;
					res = Math.max(res, count);
				} else
					count = 0;
			}
		}

		for (int i = 0; i < M[0].length; i++) {
			count = 0;
			for (int j = i, k = 0; j < M[0].length && k < M.length; j++, k++) {
				if (M[k][j] == 1) {
					count++;
					res = Math.max(res, count);
				} else
					count = 0;
			}
		}

		for (int i = 0; i < M.length; i++) {
			count = 0;
			for (int j = M[0].length - 1, k = i; j >= 0 && k < M.length; j--, k++) {
				if (M[k][j] == 1) {
					count++;
					res = Math.max(res, count);
				} else
					count = 0;
			}
		}

		for (int i = M[0].length - 1; i >= 0; i--) {
			count = 0;
			for (int j = i, k = 0; j >= 0 && k < M.length; j--, k++) {
				if (M[k][j] == 1) {
					count++;
					res = Math.max(res, count);
				} else
					count = 0;
			}
		}
		return res;
	}
}
