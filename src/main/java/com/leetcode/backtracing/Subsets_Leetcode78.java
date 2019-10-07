package com.leetcode.backtracing;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lhcxx on 18/10/14.
 */
public class Subsets_Leetcode78 {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		backtrack(res, new ArrayList<>(), nums, 0);
		return res;
	}

	private void backtrack(List<List<Integer>> list, List<Integer> tmp, int[] nums, int start) {
		list.add(new ArrayList<>(tmp));
		for (int i = start; i < nums.length; i++) {
			tmp.add(nums[i]);
			backtrack(list, tmp, nums, i + 1);
			tmp.remove(tmp.size() - 1);
		}
	}
}
