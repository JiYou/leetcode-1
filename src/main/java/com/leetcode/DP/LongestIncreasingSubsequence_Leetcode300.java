package com.leetcode.DP;

/**
 * Created by lhcxx on 18/10/1.
 */
public class LongestIncreasingSubsequence_Leetcode300 {
	public int lengthOfLIS(int[] nums) {
		int[] dp = new int[nums.length];
		int max = 0;
		for (int i = 0; i < nums.length; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i] && dp[j] + 1 > dp[i])
					dp[i] = dp[j] + 1;
			}
			if (dp[i] > max)
				max = dp[i];
		}
		return max;
	}


}
