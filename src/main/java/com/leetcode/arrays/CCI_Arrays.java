package com.leetcode.arrays;

import java.util.BitSet;

public class CCI_Arrays {
    public void rotate(int[][] matrix, int n) {
        if(matrix == null || n == 0)
        for (int i = 0; i < n / 2; i++)
            for (int j = 0; j < (n + 1) /2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = tmp;
            }
    }

    public void setZero(int[][] matrix) {
        BitSet bitRow = new BitSet();
        BitSet bitCol = new BitSet();
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++)
                if (matrix[i][i] == 0) {
                    bitRow.set(i);
                    bitCol.set(j);
                }
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++)
                if (bitCol.get(j) || bitRow.get(i))
                    matrix[i][j] = 0;

    }

    public static int searchInsertPosition(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return 0;
        for (int i = 0; i < nums.length; i++)
            if (k <= nums[i])
                return i;
        return nums.length;
    }






}
