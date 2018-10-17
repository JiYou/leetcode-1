package com.leetcode.backtracing;

/**
 * Created by lhcxx on 18/10/18.
 */
public class PalindromePartitioningII_Leetcode132 {
	public int minCut(String s) {
		if (s == null || s.length() == 0)
			return 0;
		int len = s.length();
		boolean[][] isPalindrome = new boolean[len][len];
		int[] cut = new int[len];

		for (int i = 0; i < len; i++) {
			int min = i;
			for (int j = 0; j <= i; j++) {
				if (s.charAt(i) == s.charAt(j) && (i - j < 2 || isPalindrome[j + 1][i - 1])) {
					isPalindrome[i][j] = true;
					min = j == 0 ? 0 : Math.min(min, cut[j - 1] + 1);
				}
			}
			cut[i] = min;
		}
		return cut[len - 1];
	}
}
