package leetcode;

import java.util.Arrays;

public class _198_HouseRobber {
	public int rob(int[] nums) {
		int prevNo = 0;
		int curYes = 0;
		for (int num : nums) {
			int tmp = prevNo;
			prevNo = Math.max(prevNo, curYes);
			curYes = num + tmp;
		}
		return Math.max(prevNo, curYes);
	}

	private int[] memo;

	public int rob2(int[] nums) {
		memo = new int[nums.length];
		Arrays.fill(memo, -1);
		return dp(nums, 0);
	}

	private int dp(int[] nums, int start) {
		if (start >= nums.length)
			return 0;
		if (memo[start] != -1)
			return memo[start];
		int res = Math.max(dp(nums, start + 1),
			nums[start] + dp(nums, start + 2));
		memo[start] = res;
		return res;
	}

	private int rob3(int[] nums) {
		int len = nums.length;
		int[] dp = new int[len + 1];
		dp[0] = 0;
		dp[1] = nums[0];
		for (int i = 2; i <= len; i++)
			dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
		return dp[len];
	}

}
