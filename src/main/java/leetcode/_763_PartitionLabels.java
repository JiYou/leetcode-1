package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _763_PartitionLabels {
	public List<Integer> partitionLabels(String S) {
		int[] last = new int[26];
		for (int i = 0; i < S.length(); i++)
			last[S.charAt(i) - 'a'] = i;

		int left = 0, right = 0;
		List<Integer> res = new ArrayList<>();

		for (int i = 0; i < S.length(); i++) {
			right = Math.max(right, last[S.charAt(i) - 'a']);
			if (i == right) {
				res.add(right - left + 1);
				left = i + 1;
			}
		}
		return res;
	}
}
