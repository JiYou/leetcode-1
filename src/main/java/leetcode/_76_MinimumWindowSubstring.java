package leetcode;

public class _76_MinimumWindowSubstring {
	public static String minWindow(String s, String t) {
		if (s.length() < t.length())
			return "";

		char[] sArr = s.toCharArray();
		char[] tArr = t.toCharArray();

		int[] hash = new int[256];

		for (int i = 0; i < t.length(); i++)
			hash[tArr[i]]++;

		int l = 0, count = tArr.length, max = sArr.length + 1;
		String result = "";

		for (int r = 0; r < s.length(); r++) {
			hash[sArr[r]]--;

			if (sArr[r] >= 0)
				count--;

			while (l < r && hash[sArr[l]] < 0)
				hash[sArr[l++]]++;

			if (count == 0 && max > r - l + 1) {
				max = r - l + 1;
				result = s.substring(l, r + 1);
			}
		}
		return result;
	}
}
