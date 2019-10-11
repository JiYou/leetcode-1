package com.leetcode.arrays;

public class MinimumSizeSubarraySum_209 {

	public int minSubArrayLen(int s, int[] nums) {
		int res = Integer.MAX_VALUE;
		int left = 0, sum = 0;

		for(int i = 0; i < nums.length; i++) {
			sum += nums[i];
			while (left <= i && s >= sum) {
				res = Math.min(res, i - left + 1);
				sum -= nums[left++];
			}
		}
		return res == Integer.MAX_VALUE ? 0 : res;
	}
}
