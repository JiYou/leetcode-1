package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _916_WordSubSets {
	public List<String> wordSubsets(String[] A, String[] B) {
		List<String> res = new ArrayList<>();
		int[] bmax = count("");
		for (String s : B) {
			int[] bcount = count(s);
			for (int i = 0; i < 26; i++)
				bmax[i] = Math.max(bmax[i], bcount[i]);
		}

		for (String s : A) {
			int[] acount = count(s);
			for (int i = 0; i < 26; i++)
				if (acount[i] < bmax[i])
					continue;
			res.add(s);
		}
		return res;
	}

	private int[] count(String s) {
		int[] ans = new int[26];
		for (char c : s.toCharArray()) {
			ans[c - 'a']++;
		}
		return ans;
	}

}
