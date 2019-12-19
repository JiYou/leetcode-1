package leetcode;

import java.util.Arrays;

public class _833_FindReplaceString {
	public String findReplaceString(String s, int[] indexes, String[] sources, String[] targets) {
		int len = s.length();
		int[] match = new int[len];
		Arrays.fill(match, -1);

		for (int i = 0; i < indexes.length; i++) {
			int idx = indexes[i];
			if (s.substring(idx, idx + sources[i].length()).equals(sources[i]))
				match[idx] = i;
		}

		StringBuffer sb = new StringBuffer();

		int i = 0;
		while (i < len) {
			if (match[i] != -1) {
				sb.append(targets[match[i]]);
				i += sources[match[i]].length();
			} else
				sb.append(s.charAt(i++));
		}
		return sb.toString();
	}
}
