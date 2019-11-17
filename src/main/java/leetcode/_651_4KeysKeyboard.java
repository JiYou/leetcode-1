package leetcode;

public class _651_4KeysKeyboard {
	public int max(int n) {
		int[] dp = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			dp[i] = i;
			for (int j = 1; j <= i -3; j++)
				dp[j] = Math.max(dp[j], dp[j] * (i - j - 1));
		}
		return dp[n];
	}
}
