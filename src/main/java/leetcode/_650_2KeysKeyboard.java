package leetcode;

public class _650_2KeysKeyboard {
	public int minSteps(int n) {
		int[] dp = new int[n + 1];

		for (int i = 2; i <= n; i++) {
			dp[i] = i;
			for (int j = i - 1; j > 1; j--) {
				if (i % j == 0)
					dp[i] = Math.min(dp[i], dp[j] + i / j);
			}
		}
		return dp[n];
	}

	public int minSteps2(int n) {
		int res = 0;
		for (int i = 2; i <= n; i++) {
			while (n % i == 0) {
				res += i;
				n /= i;
			}
		}
		return res;
	}
}
