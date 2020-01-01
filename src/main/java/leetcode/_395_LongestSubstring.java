package leetcode;

public class _395_LongestSubstring {
	public int longestSubstring(String s, int k) {
		if (s == null || s.length() == 0 || k < 2)
			return s.length();
		return count(s.toCharArray(), k, 0, s.length() - 1);
	}

	private int count(char[] chars, int k, int p1, int p2) {
		if (p2 - p1 + 1 < k)
			return 0;
		int[] count = new int[26];
		for (int i = p1; i <= p2; i++)
			count[chars[i] - 'a']++;

		while (p2 - p1 + 1 >= k && count[chars[p1] - 'a'] < k)
			p1++;
		while (p2 - p1 + 1 >= k && count[chars[p2] - 'a'] < k)
			p2--;

		if (p2 - p1 + 1 < k) return 0;
		for (int i = p1; i <= p2; i++) {
			if(count[chars[i] - 'a'] < k)
				return Math.max(count(chars, k, p1, i - 1), count(chars, k, i + 1, p2));
		}
		return p2 - p1 + 1;
	}
}
