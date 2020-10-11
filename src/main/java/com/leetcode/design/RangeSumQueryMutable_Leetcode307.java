package com.leetcode.design;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lhcxx on 18/10/26.
 */
public class RangeSumQueryMutable_Leetcode307 {
	private int[] sums;
	private int[] nums;
	private Map<Integer, Integer> log;

	public RangeSumQueryMutable_Leetcode307(int[] nums) {
		this.nums = nums;
		sums = new int[nums.length];
		sums[0] = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			sums[i + 1] = sums[i] + nums[i];
		}
		log = new HashMap<>();
	}

	public void update(int i, int value) {
		log.put(i, value - nums[i]);
	}

	public int sumRange(int i, int j) {
		int origin = sums[j + 1] - sums[i];
		for (Integer key : log.keySet()) {
			if (key >= i && key <= j)
				origin += log.get(key);
		}
		return origin;
	}
}
