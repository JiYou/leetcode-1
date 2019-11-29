package leetcode;

public class _62_UniquePaths {
	public int uniquePaths(int m, int n) {
		int [][] dp = new int[m + 1][n + 1];
		dp[0][0] = 1;
		for (int i = 0; i < n; i++)
			dp[0][i] = dp[0][i - 1] + 1;
		for (int i = 0; i < m; i++)
			dp[i][0] = dp[i - 1][0] + 1;
		for (int i = 1; i < m; i++)
			for (int j = 1; j < n; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		return dp[m][n];
	}

	public int uniquePaths2(int m, int n) {
		int[] dp = new int[n];
		dp[0] = 1;
		for (int i = 0; i < m; i++)
			for (int j = 1; j < n; j++)
				dp[i] = dp[j] + dp[j - 1];
		return dp[n - 1];
	}
}
