package com.leetcode.backtracing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by lhcxx on 18/10/16.
 */
public class CombinationSumII_Leetcode40 {
	public List<List<Integer>> combinationSum2(int[] nums, int k) {
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(nums);
		helper(res, new ArrayList<>(), nums, k, 0);
		return res;
	}

	private void helper(List<List<Integer>> list, List<Integer> tmp, int[] nums, int k, int start) {
		if (k < 0) return;
		if (k == 0)
			list.add(new ArrayList<>(tmp));
		else {
			for (int i = start; i < nums.length; i++) {
				if (i != start && nums[i] == nums[i - 1])
					continue;
				tmp.add(nums[i]);
				helper(list, tmp, nums, k - nums[i], i + 1);
				tmp.remove(tmp.size() - 1);
			}
		}
	}
}
