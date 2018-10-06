package com.leetcode.String;

import java.util.HashMap;

/**
 * Created by lhcxx on 18/10/3.
 */
public class LongestSubstringWithAtMostTwoDistinctCharacters_Leetcode159 {
	public int lengthOfLongestSubstringTwoDistinct(String s) {
		if (s == null || s.length() == 0)
			return 0;
		HashMap<Character, Integer> map = new HashMap<>();
		int start = 0, end = 0, res = 0;
		while (end < s.length()) {
			if (map.size() <= 2)
				map.put(s.charAt(end), end++);
			else {
				int leftMost = s.length();
				for (int val : map.values())
					start = Math.min(start, val);
				map.remove(s.charAt(leftMost));
				start = leftMost + 1;
			}
			res = Math.max(res, end - start);
		}
		return res;
	}
}
