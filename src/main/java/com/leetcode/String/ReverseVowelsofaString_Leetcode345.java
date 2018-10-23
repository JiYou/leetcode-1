package com.leetcode.String;

/**
 * Created by lhcxx on 18/10/20.
 */
public class ReverseVowelsofaString_Leetcode345 {
	public String reverseVowels(String s) {
		if (s == null || s.length() == 0)
			return s;
		String vowels = "aeiouAEIOU";
		char[] array = s.toCharArray();
		int start = 0, end = s.length() - 1;
		while (start < end) {
			while (start < end && vowels.indexOf(array[start]) == -1)
				start++;
			while (start < end && vowels.indexOf(array[end]) == -1)
				end--;
			char tmp = array[start];
			array[start] = array[end];
			array[end] = tmp;
		}
		return new String(array);
	}
}
