package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _267_PalindromePermutationII {
	public List<String> generatePalindromes(String s) {
		List<String> res = new ArrayList<>();
		int odd = 0;
		HashMap<Character, Integer> map = new HashMap<>();
		List<Character> list = new ArrayList<>();
		String mid = "";

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			map.put(c, map.getOrDefault(c, 0) + 1);
			odd += map.get(c) % 2 != 0 ? 1 : -1;
		}
		if (odd > 1) return res;

		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			char key = entry.getKey();
			int val = entry.getValue();
			if (val % 2 != 0) mid += key;
			for (int i = 0; i < val / 2; i++)
				list.add(key);
		}
		helper(res, mid, new boolean[list.size()], list, new StringBuffer());
		return res;
	}


	private void helper(List<String> res, String mid, boolean[] used, List<Character> list, StringBuffer sb) {
		if (sb.length() == list.size()) {
			res.add(sb.toString() + mid + sb.reverse().toString());
			sb.reverse();
			return;
		}

		for (int i = 0; i < list.size(); i++) {
			if (i > 0 && list.get(i) == list.get(i - 1) && used[i]) continue;
			if (!used[i]) {
				sb.append(list.get(i));
				used[i] = true;
				helper(res, mid, used, list, sb);
				used[i] = false;
				sb.deleteCharAt(sb.length() - 1);
			}
		}
	}



}
