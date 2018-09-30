package com.leetcode.arrays;

import java.util.Arrays;

/**
 * Created by lhcxx on 18/9/26.
 */
public class HIndex_Leetcode274 {
	public int hIndex(int[] nums) {
		Arrays.sort(nums);
		int h = 0;
		while (h < nums.length && nums[nums.length - 1 - h] > h)
			h++;
		return h;
	}
}
