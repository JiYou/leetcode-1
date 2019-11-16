package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _17_LetterCombinationsofaPhoneNumber {

	private String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

	public List<String> letterCombinations(String digits) {
		List<String> res = new ArrayList<>();
		if (digits == null || digits.length() == 0)
			return res;
		helper(res, digits, "", 0);
		return res;
	}

	private void helper(List<String>res, String digits, String s, int index) {
		if (index == digits.length()) {
			res.add(s);
			return;
		}
		String strs = mapping[digits.charAt(index) - '0'];
		for (int i = 0; i < strs.length(); i++) {
			helper(res, digits, s + strs.charAt(i), index + 1);
		}
	}
}
