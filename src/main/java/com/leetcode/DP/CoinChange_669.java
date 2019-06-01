package com.leetcode.DP;

public class CoinChange_669 {
	public int coinChange(int[] a, int m) {
		int[] f = new int[m + 1];
		int n = a.length;

		f[0] = 0;

		for (int i = 1; i <= m; i++) {
			f[i] = Integer.MAX_VALUE;
			for (int j = 0; j < n; j++)
				if (i >= a[j] && f[i - a[j]] != Integer.MAX_VALUE)
					f[i] = Math.min(f[i - a[j]] + 1, f[i]);
		}

		if (f[m] == Integer.MAX_VALUE)
			f[m] = -1;
		return f[m];
	}
}
