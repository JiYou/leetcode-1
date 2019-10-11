package com.leetcode.DFS;

public class WallsandGates_286 {
	public void wallsAndGates(int[][] nums) {
		for (int i = 0; i < nums.length; i++)
			for (int j = 0; j < nums[0].length; j++)
				if (nums[i][j] == 0)
					dfs(nums, i, j, 0);
	}

	private void dfs(int[][] nums, int i, int j, int dis) {
		if (i < 0 || i > nums.length || j < 0 || j > nums[0].length || nums[i][j] < dis)
			return;
		nums[i][j] = dis;
		dfs(nums, i - 1, j, dis + 1);
		dfs(nums, i + 1, j, dis + 1);
		dfs(nums, i, j + 1, dis + 1);
		dfs(nums, i, j - 1, dis + 1);
	}
}
