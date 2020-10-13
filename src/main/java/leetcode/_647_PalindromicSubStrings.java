package leetcode;

public class _647_PalindromicSubStrings {

	int res = 0;
	public int countSubStrings(String s) {
		if (s == null || s.length() == 0)
			return 0;
		for (int i = 0; i < s.length(); i++) {
			res = helper(s, i, i);
			res = helper(s, i, i + 1);
		}
			//res = Math.max(Math.max(res, helper(s, i, i)), helper(s, i, i + 1));
		return res;
	}

	private int helper(String s, int i, int j) {
		while (i >=0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
			i--;
			j++;
			res++;
		}
		return res;
	}
}
