package com.leetcode.String;

/**
 * Created by lhcxx on 18/10/2.
 */
public class LongestSubstringwithAtMostKDistinctCharacters_Leetcode340 {
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
		int[] count = new int[256];
		int num = 0, j = 0, res = 0;
		for (int i = 0 ; i < s.length(); i++) {
			if (count[s.charAt(i)]++ == 0) num++;
			if (num > k) {
				while (--count[s.charAt(j++)] > 0);
				num--;
			}
			res = Math.max(res, i - j + 1);
		}
		return res;
	}
}


