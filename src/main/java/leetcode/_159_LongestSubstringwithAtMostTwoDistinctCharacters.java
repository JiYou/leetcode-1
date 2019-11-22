package leetcode;

public class _159_LongestSubstringwithAtMostTwoDistinctCharacters {
	public int lengthOfLongestSubstringTwoDistinct(String s) {
		if (s == null || s.length() == 0)
			return 0;
		char[] arr = s.toCharArray();
		int[] hash = new int[256];

		int l = 0, count = 0, res = 1;

		for (int r = 0; r < arr.length; r++) {
			hash[arr[r]]++;

			if (hash[arr[r]] == 1)
				count++;

			while (count > 2) {
				hash[arr[l]]--;
				if (hash[arr[l]] == 0)
					count--;
				l++;
			}

			res = Math.max(res, r - l + 1);
		}
		return res;
	}
}
