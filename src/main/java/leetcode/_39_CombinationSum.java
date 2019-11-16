package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _39_CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<>();
		helper(res, new ArrayList<>(), candidates, target, 0);
		return res;
	}

	private void helper(List<List<Integer>>res, List<Integer> list, int[] nums, int target, int start) {
		if (target < 0) return;
		if (target == 0){
			res.add(new ArrayList<>(list));
			return;
		}
		for (int i = start; i < nums.length; i++) {
				list.add(nums[i]);
				helper(res, list, nums, target - nums[i], i);
				list.remove(list.size() - 1);
		}
	}

}
