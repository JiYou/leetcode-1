package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _438_FindAllAnagramsInAString {
	public List<Integer> findAllAnagrams(String s, String p) {
		List<Integer> res = new ArrayList<>();
		if (s == null || p == null || s.length() < p.length())
			return res;
		int[] chars = new int[26];
		for (char c : p.toCharArray())
			chars[c - 'a']++;
		int count = p.length();
		int start = 0, end = 0;

		while (end < s.length()) {
			if (end - start == p.length() && chars[s.charAt(start++) - 'a']++ >= 0)
				count++;
			if (--chars[s.charAt(end++) - 'a'] >= 0)
				count--;
			if (count == 0)
				res.add(start);
		}
		return res;
	}
}
