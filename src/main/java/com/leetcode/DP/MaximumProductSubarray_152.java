package com.leetcode.DP;

public class MaximumProductSubarray_152 {
	/*public int maxProduct(int[] nums){
		int n = nums.length;
		int[] f = new int[n];
		f[0] = nums[0];
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < n; i++) {

		}
	}*/

	public int maxProduct(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int max = nums[0];
		int min = nums[0];
		int res = nums[0];

		for (int i = 1; i < nums.length; i++) {
			int tmp = max;
			max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
			min = Math.min(Math.min(tmp * nums[i], min * nums[i]), nums[i]);
			res = Math.max(res, max);
		}

		return res;
	}
}
