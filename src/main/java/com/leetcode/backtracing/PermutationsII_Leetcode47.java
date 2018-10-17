package com.leetcode.backtracing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lhcxx on 18/10/16.
 */
public class PermutationsII_Leetcode47 {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(nums);
		helper(res, new ArrayList<>(), nums, new boolean[nums.length]);
		return res;
	}

	private void helper(List<List<Integer>> list, List<Integer> tmp, int[] nums, boolean[] used) {
		if (tmp.size() == nums.length) {
			list.add(new ArrayList<>(tmp));
		}
		for (int i = 0; i < nums.length; i++) {
			if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
				continue;
			used[i] = true;
			tmp.add(nums[i]);
			helper(list, tmp, nums, used);
			used[i] = false;
			tmp.remove(tmp.size() - 1);
		}
	}


}
