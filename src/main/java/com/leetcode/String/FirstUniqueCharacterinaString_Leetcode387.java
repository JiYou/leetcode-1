package com.leetcode.String;

/**
 * Created by lhcxx on 18/10/1.
 */
public class FirstUniqueCharacterinaString_Leetcode387 {
	public int firstUniqueChar(String s) {
		int[] count = new int[26];
		for(int i = 0; i < s.length(); i++)
			count[s.charAt(i) - 'a']++;
		for (int i = 0; i < s.length(); i++)
			if (count[s.charAt(i) - 'a'] == 1)
				return i + 1;
		return -1;
	}
}
