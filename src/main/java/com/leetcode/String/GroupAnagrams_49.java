package com.leetcode.String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams_49 {

	public List<List<String>> groupAnagrams(String[] strs) {
		HashMap<String, List<String>> map = new HashMap<>();

		for (String str: strs) {
			int[] count = new int[26];
			for (Character c : str.toCharArray()) {
				count[c - 'a']++;
			}
			String s = "";
			for (int i = 0; i < count.length; i++)
				if (count[i] != 0)
					s += String.valueOf(count[i]) + String.valueOf(i + 'a');
			if (map.containsKey(s)) {
				map.get(s).add(str);
			} else {
				List<String> list = new ArrayList<>();
				list.add(str);
				map.put(s, list);
			}
		}
		return new ArrayList<>(map.values());
	}
}
