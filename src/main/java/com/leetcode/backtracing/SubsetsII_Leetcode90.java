package com.leetcode.backtracing;

import com.leetcode.arrays.IntersectionofTwoArrays_Leetcode349;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lhcxx on 18/10/15.
 */
public class SubsetsII_Leetcode90 {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums == null || nums.length == 0) return res;
		Arrays.sort(nums);
		backtrack(res, new ArrayList<>(), nums, 0);
		return res;
	}

	private void backtrack(List<List<Integer>> list, List<Integer> tmp, int[] nums, int start) {
		list.add(new ArrayList<>(tmp));
		for (int i = start; i < nums.length; i++) {
			if (i != start && nums[i] == nums[i - 1])
				continue;
			tmp.add(nums[i]);
			backtrack(list, tmp, nums, i + 1);
			tmp.remove(tmp.size() - 1);
		}
	}


	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums == null || nums.length == 0)
			return res;
		Arrays.sort(nums);
		helper(res, new ArrayList<>(), nums, 0);
		return res;
	}

	private void helper(List<List<Integer>>res, List<Integer> list, int[] nums, int index) {
		res.add(new ArrayList<>(list));
		for (int i = index; i < nums.length; i++){
			if (i != index && nums[i] == nums[i - 1]) continue;
			list.add(nums[i]);
			helper(res, list, nums, index + 1);
			list.remove(list.size() - 1);
		}
	}
}
