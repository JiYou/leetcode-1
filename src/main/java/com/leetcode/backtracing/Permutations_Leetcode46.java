package com.leetcode.backtracing;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lhcxx on 18/10/15.
 */
public class Permutations_Leetcode46 {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		backtrack(res, new ArrayList<>(), nums);
		return res;
	}

	private void backtrack(List<List<Integer>>list, List<Integer> tmp, int[] nums) {
		if (tmp.size() == nums.length) {
			list.add(tmp);
		}
		for (int i = 0 ; i < nums.length; i++) {
			if (tmp.contains(nums[i]))
				continue;
			tmp.add(nums[i]);
			backtrack(list, tmp, nums);
			tmp.remove(tmp.size() - 1);
		}
	}
}
