package com.leetcode.normal;

import java.util.Arrays;

public class LongestIncreasingSubsequence_300 {
	public int lengthOfLIS(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int[] dp = new int[nums.length + 1];
		dp[0] = 1;
		Arrays.fill(dp, 1);
		int max = 1;
		for (int i = 1; i <= nums.length; i++) {
			for (int j = 0; j < i; j++)
				if (nums[i] > nums[j])
					dp[i] = Math.max(dp[i], dp[j] + 1);
			max = Math.max(max, dp[i]);
		}
		return max;
	}

	public int lengthOfLIS2(int[] nums) {
		int[] tails = new int[nums.length];
		int res = 0;
		for (int num : nums) {
			int i = 0, j = res;
			while (i != j) {
				int mid = (i + j) / 2;
				if (tails[mid] < num)
					i = mid + 1;
				else
					j = mid;
			}
			tails[i] = num;
			if (i == res) ++res;
		}
		return res;
	}
}
