package com.leetcode.String;

/**
 * Created by lhcxx on 18/10/3.
 */
public class MinimumWindowSubstring_Leetcode76 {
	public String miniWindow(String s, String t) {
		int[] count = new int[128];
		for(char c : t.toCharArray()) {
			count[c]++;
		}
		int from = 0;
		int min = Integer.MAX_VALUE;
		int total = t.length();
		for (int i = 0, j = 0; i < s.length(); i++) {
			if (count[s.charAt(i)]-- > 0)
				total--;
			while (total == 0) {
				if (min > i - j + 1) {
					min = i - j + 1;
					from = j;
				}
				if (++count[s.charAt(j++)] > 0)
					total++;
			}
		}
		return min == Integer.MAX_VALUE ? "" : s.substring(from, from + min);
	}
}
