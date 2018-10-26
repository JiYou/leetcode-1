package com.leetcode.design;

import java.util.HashMap;

/**
 * Created by lhcxx on 18/10/26.
 */
public class UniqueWordAbbreviation_Leetcode288 {
	private HashMap<String, String> map;

	public UniqueWordAbbreviation_Leetcode288(String[] strs) {
		for (String s : strs) {
			String key = getKey(s);
			if (map.containsKey(key)) {
				if (!map.get(key).equals(s))
					map.put(key, "");
			} else
				map.put(key, s);
		}
	}

	private String getKey(String s) {
		if (s.length() < 3)
			return s;
		return s.charAt(0) + Integer.toString(s.length() - 2) + s.charAt(s.length() - 1);
	}

	private boolean isUnique(String s) {
		return (!map.containsKey(getKey(s))) || map.get(getKey(s)).equals(s);
	}
}
