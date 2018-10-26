package com.leetcode.design;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by lhcxx on 18/10/27.
 */
public class LFUCache {
	HashMap<Integer, Integer> cache;
	HashMap<Integer, Integer> keyCounts;
	HashMap<Integer, HashSet<Integer>> countKeySet;
	int capacity;
	int min;

	public LFUCache(int capacity) {
		this.capacity = capacity;
		min = -1;
		cache = new HashMap<>();
		keyCounts = new HashMap<>();
		countKeySet = new HashMap<>();
		countKeySet.put(1, new HashSet<>());
	}

	public void put(int key, int value) {
		if (this.capacity <= 0)
			return;

		if (cache.containsKey(key)) {
			cache.put(key, value);
			get(key);
		}

		if (cache.size() >= capacity) {
			int leastFreq = countKeySet.get(min).iterator().next();
			cache.remove(leastFreq);
			keyCounts.remove(leastFreq);
			countKeySet.get(min).remove(leastFreq);
		}

		cache.put(key, value);
		keyCounts.put(key, 1);
		countKeySet.get(1).add(key);
		min = 1;
	}

	public int get(int key) {
		if (!cache.containsKey(key))
			return -1;
		int count = keyCounts.get(key);
		keyCounts.put(key, count + 1);
		countKeySet.get(count).remove(key);
		if (count == min && countKeySet.get(count).size() == 0)
			min++;
		if (!countKeySet.containsKey(count + 1))
			countKeySet.put(count + 1, new HashSet<>());
		countKeySet.get(count + 1).add(key);
		return cache.get(key);
	}

}
