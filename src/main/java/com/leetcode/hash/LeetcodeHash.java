package com.leetcode.hash;

import java.util.*;

public class LeetcodeHash {


	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> res = new ArrayList<>();
		if (strs == null || strs.length == 0) return res;
		HashMap<String, Integer> map = new HashMap<>();
		for (String str : strs) {
			char[] ch = str.toCharArray();
			Arrays.sort(ch);
			String s = Arrays.toString(ch);
			if (map.containsKey(s)) {
				List<String> list = res.get(map.get(s));
				list.add(str);
			}else {
				List<String> list = new ArrayList<>();
				list.add(str);
				map.put(s, res.size());
				res.add(list);
			}
		}
		return res;
	}

	public boolean isIsomorphicString(String s, String t) {
		if (s == null || t == null)
			return true;
		if (s.length() != t.length())
			return false;
		HashMap<Character,Character> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char a = s.charAt(i);
			char b = t.charAt(i);
			if (map.containsKey(a)) {
				if(map.get(a).equals(b)) continue;
				else return false;
			} else {
				if (!map.containsValue(b))
					map.put(a, b);
				else return false;
			}
		}
		return true;
	}






}
