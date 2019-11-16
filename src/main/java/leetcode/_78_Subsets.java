package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _78_Subsets {
	public  List<List<Integer>> subsets(int[] nums) {
		if (nums == null || nums.length == 0)
			return null;
		List<List<Integer>> res = new ArrayList<>();
		helper(res, new ArrayList<>(), nums, 0);
		return res;
	}

	private void helper(List<List<Integer>> res, List<Integer>list, int[] nums, int index) {
		res.add(new ArrayList<>(list));
		for (int i = index; i < nums.length; i++) {
			list.add(nums[i]);
			helper(res, list, nums, index + 1);
			list.remove(list.size() - 1);
		}
	}
}
