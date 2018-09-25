package com.leetcode.arrays;

/**
 * Created by lhcxx on 18/9/26.
 */
public class MaximumSubarray_Leetcode53 {
	public int maxSubArray(int[] nums) {
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		int res = dp[0];
		for (int i = 1; i < nums.length; i++){
			dp[i] = nums[i] + (dp[i - 1] < 0 ? 0 : dp[i - 1]);
			res = Math.max(res, dp[i]);
		}
		return res;
	}

	public int maxSubArray2(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int cur = nums[0], max = nums[0];
		for (int i = 1; i < nums.length; i++){
			cur = Math.max(cur + nums[i], nums[i]);
			max = Math.max(cur, max);
		}
		return max;
	}
}
