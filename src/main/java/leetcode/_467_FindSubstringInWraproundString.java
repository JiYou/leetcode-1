package leetcode;

public class _467_FindSubstringInWraproundString {
	public int findSubstringInWraproundString(String p) {
		int[] dp = new int[26];

		int k = 0;
	//	dp[p.charAt(0) - 'a'] = 1;
		for (int i = 0; i < p.length(); i++) {
			if (i > 0 && isContinous(p.charAt(i - 1), p.charAt(i)))
				k++;
			else
				k = 1;
			dp[p.charAt(i) - 'a'] = Math.max(dp[p.charAt(i) - 'a'], k);
		}
		int res = 0;
		for (int i : dp)
			res += i;
		return res;
	}

	private boolean isContinous(char prev, char cur) {
		if (prev == 'z')
			return cur == 'a';
		return prev + 1 == cur;
	}
}
