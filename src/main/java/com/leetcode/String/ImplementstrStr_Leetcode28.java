package com.leetcode.String;

/**
 * Created by lhcxx on 18/10/1.
 */
public class ImplementstrStr_Leetcode28 {
	public int strStr(String heystack, String needle) {
		if (needle.length() == 0) return 0;
		for (int i = 0; i <= heystack.length() - needle.length(); i++)
			if (heystack.substring(i, i + needle.length()).equals(needle))
				return i;
		return -1;
	}
}
