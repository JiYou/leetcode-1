package leetcode;

public class _322_CoinChange {
	public int coinChange(int[] coins, int amount) {
		int[] dp = new int[amount + 1];
		dp[0] = 0;

		for (int i = 1; i <= amount; i++) {
			dp[i] = Integer.MAX_VALUE;
			for (int j = 0; j < coins.length; j++) {
				if (i >= coins[j])
					dp[i] = Math.min(dp[i - coins[j]] + 1, dp[i]);
			}
		}
		if (dp[amount] == Integer.MAX_VALUE)
			return -1;
		return dp[amount];
	}
}
