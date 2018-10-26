package com.leetcode.design;

/**
 * Created by lhcxx on 18/10/26.
 */
public class RangeSumQueryImmutable_Leetcode303 {
	private int[] sum;

	public RangeSumQueryImmutable_Leetcode303(int[] nums) {
		sum = new int[nums.length];
		sum[0] = 0;
		for (int i = 0; i < nums.length; i++)
			sum[i + 1] = sum[i] + nums[i];
	}

	public int sumRange(int i, int j) {
		return sum[j + 1] - sum[i];
	}
}
