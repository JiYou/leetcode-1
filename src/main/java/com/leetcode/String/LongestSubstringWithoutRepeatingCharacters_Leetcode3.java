package com.leetcode.String;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by lhcxx on 18/10/18.
 */
public class LongestSubstringWithoutRepeatingCharacters_Leetcode3 {
	public int lengthOfLongestSubstring(String s) {
		if(s == null || s.length() == 0)
			return 0;
		HashMap<Character, Integer> map = new HashMap<>();
		int res = 0;
		for (int i = 0, j = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i)))
				j = Math.max(j, map.get(s.charAt(i)) + 1);
			map.put(s.charAt(i), i);
			res = Math.max(res, i - j + 1);
		}
		return res;
	}

	public int lengthOfLongestSubstring2(String s) {
		if(s == null || s.length() == 0)
			return 0;
		HashSet<Character> set = new HashSet<>();
		int res = 0;
		for (int i = 0, j = 0; i < s.length(); i++) {
			if (set.contains(s.charAt(i))) {
				set.remove(s.charAt(j++));
			} else {
				set.add(s.charAt(i));
				res = Math.max(res, set.size());
			}
		}
		return res;
	}
}
