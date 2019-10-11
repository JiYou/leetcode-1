package com.leetcode.DP;

public class UniquePathsII_63 {
	public int uniquePathsWithObstacles(int[][] nums) {
		int len = nums[0].length;
		int[] res = new int[len];
		res[0] = 1;
		for (int i = 0; i < nums.length; i++)
			for (int j = 0; j < len; j++) {
				if (nums[i][j] == 1)
					res[j] = 0;
				else if (j > 0)
					res[j] += res[j - 1];
			}
		return res[len - 1];
	}
}
