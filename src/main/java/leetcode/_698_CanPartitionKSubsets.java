package leetcode;

import java.util.Arrays;

public class _698_CanPartitionKSubsets {
	public boolean canPartitionKSubsets(int[] nums, int k) {
		int sum = Arrays.stream(nums).sum();
		if (sum % k > 0) return false;
		int target = sum / k;
		Arrays.sort(nums);
		int row = nums.length - 1;
		if (nums[row] > target) return false;
		while (row >= 0 && nums[row] == target) {
			row--;
			k--;
		}
		//return helper(new int[k], row, nums, target);
		boolean[] used = new boolean[nums.length];
		return backtracking(nums, k, sum/k, 0, 0, used);
	}

	private boolean helper(int[] groups, int row, int[] nums, int target) {
		if (row < 0) return true;
		int v = nums[row--];
		for (int i = 0; i < groups.length; i++) {
			if (groups[i] + v <= target) {
				groups[i] += v;
				if (helper(groups, row, nums, target))
					return true;
				groups[i] -= v;
			}
			if (groups[i] == 0) break;
		}
		return false;
	}

	private boolean backtracking(int[] nums, int k, int target, int cur, int start, boolean[] used ) {
		// 返回条件
		if (k == 0) return true;
		if (cur == target) {
			// 构建下一个集合
			return backtracking(nums, k-1, target, 0, 0, used);
		}
		for (int i = start; i < nums.length; i++) {
			if (!used[i] && cur+nums[i] <= target) {
				used[i] = true;
				if (backtracking(nums, k, target, cur+nums[i], i+1, used)) return true;
				used[i] = false;
			}
		}
		return false;
	}
}
