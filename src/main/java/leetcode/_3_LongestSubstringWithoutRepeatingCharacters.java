package leetcode;

public class _3_LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0)
			return 0;

		char[] sArr = s.toCharArray();

		int[] hash = new int[256];

		int l = 0, res = 1;

		for (int r = 0; r < sArr.length; r++) {
			hash[sArr[r]]++;

			while (hash[sArr[r]] != 1) {
				hash[sArr[l]]--;
				l++;
			}

			res = Math.max(res, r - l + 1);
		}
		return res;
	}
}
