package com.leetcode.String;

/**
 * Created by lhcxx on 18/10/20.
 */
public class ValidPalindrome_Leetcode125 {
	public boolean isPalindrome(String s) {
		if (s == null || s.length() == 0) return true;
		int left = 0, right = s.length() - 1;
		while (left < right) {
			while (left < right && !Character.isLetterOrDigit(s.charAt(left)))
				left++;
			while (left < right && !Character.isLetterOrDigit(s.charAt(right)))
				right--;
			if (Character.toLowerCase(s.charAt(left))!= Character.toLowerCase(s.charAt(right)))
				return false;
			left++;
			right--;
		}
		return true;
	}
}
