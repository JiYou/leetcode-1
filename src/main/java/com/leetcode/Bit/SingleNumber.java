package com.leetcode.Bit;

/**
 * Created by lhcxx on 18/10/8.
 */
public class SingleNumber {
	public int singleNumber(int[] nums) {
		int res = 0;
		for (int i = 0; i < nums.length; i++)
			res ^= nums[i];
		return res;
	}
}
