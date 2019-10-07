package com.leetcode.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TopKFrequent_347 {
	public List<Integer> topKFrequent(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i : nums)
			map.put(i, map.getOrDefault(i, 0) + 1);
		int[] bucket = new int[nums.length + 1];
		Arrays.fill(bucket, -1);
		for (Integer key : map.keySet()) {
			int freq = map.get(key);
			bucket[freq] = key;
		}

		List<Integer> res = new ArrayList<>();
		for (int i = bucket.length - 1; i >= 0 && res.size() < k; i--)
			if (bucket[i] != -1)
				res.add(bucket[i]);
		return res;
	}
}
