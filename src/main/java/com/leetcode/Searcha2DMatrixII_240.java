package com.leetcode;

public class Searcha2DMatrixII_240 {
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0) return false;
		int row = 0, col = matrix[0].length - 1;
		while (row <= matrix.length - 1 && col >= 0) {
			if (matrix[row][col] == target)
				return true;
			else if (matrix[row][col] > target)
				col--;
			else
				row++;
		}
		return false;
	}
}
