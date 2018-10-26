package com.leetcode.design;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lhcxx on 18/10/26.
 */
public class TwoSumIII_Leetcode170 {
	private HashMap<Integer, Integer> map;

	public TwoSumIII_Leetcode170() {
		map = new HashMap<>();
	}

	public void add(Integer a) {
		if (map.containsKey(a))
			map.put(a, map.get(a) + 1);
		else
			map.put(a, 1);
	}

	public boolean find(int value) {
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			int i = entry.getKey();
			int j = value - i;
			if ((i == j) && entry.getValue() > 1 || (i != j) && map.containsKey(j))
				return true;
		}
		return false;
	}

}
