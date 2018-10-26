package com.leetcode.design;

/**
 * Created by lhcxx on 18/10/26.
 */
public class RangeSumQuery2DImmutable_Leetcode304 {
	private int[][] sums;

	public RangeSumQuery2DImmutable_Leetcode304(int[][] nums) {
		int row = nums.length;
		int col = nums[0].length;
		sums = new int[row + 1][col + 1];

		for (int i = 1; i <= row; i++)
			for (int j = 1; j <= col; j++)
				sums[i][j] = sums[i - 1][j] + sums[i][j - 1] - sums[i - 1][j - 1] - nums[i - 1][j - 1];
	}

	public int sumRegion(int row1, int col1, int row2, int col2) {
		int iMin = Math.min(row1, row2);
		int iMax = Math.max(row1, row2);
		int jMin = Math.min(col1, col2);
		int jMax = Math.max(col1, col2);
		return sums[iMax + 1][jMax + 1] - sums[iMax + 1][jMin] - sums[iMin][jMax + 1] + sums[iMin][jMin];
	}
}
