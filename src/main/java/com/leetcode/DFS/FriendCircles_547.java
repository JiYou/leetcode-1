package com.leetcode.DFS;

public class FriendCircles_547 {
	private int n;

	public int findCircleNum(int[][] nums) {
		n = nums.length;
		boolean[] visited = new boolean[n];
		int res = 0;
		for (int i = 0; i < n; i++)
			if (!visited[i]) {
				dfs(nums, i, visited);
				res++;
			}
		return res;
	}

	private void dfs(int[][] nums, int i, boolean[] visited) {
		visited[i] = true;
		for (int j = 0; j < n; j++)
			if (nums[i][j] == 1 && !visited[j])
				dfs(nums, j, visited);
	}
}
