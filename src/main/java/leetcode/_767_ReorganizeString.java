package leetcode;

import java.util.Arrays;

public class _767_ReorganizeString {
	public String reorganizeString(String s) {
		int len = s.length();
		int[] counts = new int[26];
		for (char c : s.toCharArray())
			counts[c - 'a'] += 100;
		for (int i = 0; i < 26; i++)
			counts[i] += i;
		Arrays.sort(counts);

		char[] ans = new char[len];
		int t = 1;
		for (int code : counts) {
			int ct = code / 100;
			char ch = (char) ('a' + code % 100);
			if (ct > (len + 1) / 2)
				return "";
			for (int i = 0; i < ct; i++) {
				if (t > len)
					t = 0;
				ans[t] = ch;
				t += 2;
			}
		}
		return String.valueOf(ans);
	}
}
