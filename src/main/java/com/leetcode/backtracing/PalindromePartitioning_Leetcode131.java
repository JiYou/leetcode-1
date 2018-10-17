package com.leetcode.backtracing;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lhcxx on 18/10/17.
 */
public class PalindromePartitioning_Leetcode131 {
	public List<List<String>> partition(String s) {
		List<List<String>> res = new ArrayList<>();
		helper(res, new ArrayList<>(), s);
		return res;
	}

	private void helper(List<List<String>> list, List<String> tmp, String s) {
		if (s.length() == 0) {
			list.add(new ArrayList<>(tmp));
			return;
		}
		else {
			for (int i = 0; i < s.length(); i++) {
				if (isPalindrome(s.substring(0, i + 1))) {
					tmp.add(s.substring(0, i + 1));
					helper(list, tmp, s.substring(i + 1));
					tmp.remove(tmp.size() - 1);
				}
			}
		}
	}

	private boolean isPalindrome(String s) {
		for (int i = 0; i < s.length() / 2; i++)
			if (s.charAt(i) != s.charAt(s.length() - i - 1))
				return false;
		return true;
	}

}
