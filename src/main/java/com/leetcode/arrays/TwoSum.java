package com.leetcode.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class TwoSum {
	public static int[] twoSumWithHashMap(Vector<Integer> nums, int K) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int res[] = new int[] {0, 0};
		for (int i = 0; i < nums.size(); i++)
			map.put(i, nums.get(i));
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (map.containsValue(K - entry.getValue())) {
				res[0] = entry.getKey();
				break;
			}
		}
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() == (K - map.get(res[0]))){
				res[1] = entry.getKey();
				break;
			}
		}
		return res;
	}



}
