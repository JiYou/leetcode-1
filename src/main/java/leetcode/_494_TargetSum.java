package leetcode;

import com.leetcode.common.TreeNode;

public class _494_TargetSum {
	public int findTargetSum(int[] nums, int s) {
		int sum = 0;
		for (int num : nums)
			sum += num;

		if (s > sum || s < -sum)
			return 0;

		int[] dp = new int[2 * sum + 1];
		dp[sum] = 1;
		for (int i = 0; i < nums.length; i++) {
			int[] next = new int[2 * sum + 1];
			for (int j = 0; j < 2 * sum + 1; j++){
				if (dp[j] != 0) {
					next[j + nums[i]] += dp[j];
					next[j - nums[i]] += dp[j];
				}
			}
			dp = next;
		}
		return dp[sum + s];
	}

	int count = 0;
	public int findTargetSum2(int[] nums, int s) {
		calculate(nums, 0, 0, s);
		return count;
	}

	private void calculate(int[] nums, int i, int sum, int s) {
		if (i == nums.length && sum == s)
			count++;
		else {
			calculate(nums, i + 1, sum + nums[i], s);
			calculate(nums, i + 1, sum - nums[i], s);
		}
	}
}
