package com.leetcode.backtracing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lhcxx on 18/10/16.
 */
public class CombinationSum_Leetcode39 {
	public List<List<Integer>> combinationSum(int[] nums, int k) {
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(nums);
		helper(res, new ArrayList<>(), nums, k, 0);
		return res;
 	}

	private void helper(List<List<Integer>> list, List<Integer> tmp, int[] nums, int remain, int start) {
		if (remain < 0)
			return;
		if (remain == 0) {
			list.add(new ArrayList<>(tmp));
		} else {
			for (int i = start ; i < nums.length; i++) {
				tmp.add(nums[i]);
				helper(list, tmp, nums, remain - nums[i], i);
				tmp.remove(tmp.size() - 1);
			}
		}
	}
}
