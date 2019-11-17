package leetcode;

import java.util.HashSet;
import java.util.List;

public class _676_ImplementMagicDictionary {

	private HashSet<String> set;

	public _676_ImplementMagicDictionary(List<String> dict) {
		set = new HashSet<>();
		buildDict(dict);
	}

	private void buildDict(List<String> dict) {
		for (String s : dict)
			set.add(s);
	}

	public boolean search(String word) {
		char[] arr = word.toCharArray();

		for (int i = 0; i < arr.length; i++) {
			char t = arr[i];
			for (char c = 'a'; c <= 'z'; c++) {
				if (c == t)
					continue;
				arr[i] = c;
				if (set.contains(arr))
					return true;
			}
			arr[i] = t;
		}
		return false;
	}
}
