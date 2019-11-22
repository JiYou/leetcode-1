package leetcode;

public class _424_LongestRepeatingCharacterReplacement {
	public int characterReplacement(String s, int k) {
		char[] count = new char[26];
		int start = 0, max = 0, res = 0;

		for (int r = 0; r < s.length(); r++){
			max = Math.max(max, ++count[s.charAt(r) - 'A']);
			if (r - start + 1 - max > k) {
				count[s.charAt(start) - 'A']--;
				start++;
			}
			res = Math.max(res, r - start + 1);
		}
		return res;
	}
}
