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

	public List<List<Integer>> subsets_test(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		helper_test(res, new ArrayList<>(), nums, 0);
		return res;
	}

	private void helper_test(List<List<Integer>> res, List<Integer> list, int[] nums, int index) {
		res.add(new ArrayList<>(list));
		for (int i = index; i < nums.length; i++) {
			list.add(nums[i]);
			helper_test(res, list, nums, index + 1);
			list.remove(list.size() - 1);
		}
	}


}
