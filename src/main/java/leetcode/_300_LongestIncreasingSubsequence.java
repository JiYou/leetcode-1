package leetcode;

public class _300_LongestIncreasingSubsequence {
	public int lengthOfLIS(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int[] dp = new int[nums.length + 1];
		dp[0] = 1;
		int res = 0;
		for (int i = 1; i < nums.length; i++)
			for (int j = 0; j < i; j ++)
				if (nums[i] > nums[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
					res = Math.max(res, dp[i]);
				}
		return res;
	}
}
