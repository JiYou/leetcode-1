package leetcode;

public class _5_LongestPalindromicSubstring {
	String res = "";
	public String longestPalindromicSubString(String s) {
		if (s == null || s.length() == 0)
			return s;
		for (int i = 0; i < s.length(); i++) {
			helper(s, i, i);
			helper(s, i, i + 1);
		}
		return res;
	}

	private void helper(String s, int left, int right) {
		while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		String cur = s.substring(left + 1, right);
		if(cur.length() > res.length())
			res = cur;
	}
}


