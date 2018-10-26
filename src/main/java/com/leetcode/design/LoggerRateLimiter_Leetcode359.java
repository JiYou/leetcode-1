package com.leetcode.design;

import java.util.HashMap;

/**
 * Created by lhcxx on 18/10/25.
 */
public class LoggerRateLimiter_Leetcode359 {
	private HashMap<String, Integer> map;

	public LoggerRateLimiter_Leetcode359() {
		map = new HashMap<>();
	}

	public boolean shouldPrintMessage(int timestamp, String message) {
		if (!map.containsKey(message) || timestamp - map.get(message) >= 10) {
			map.put(message, timestamp);
			return true;
		}
		return false;
	}
}
