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


	public static int[] twoSum(int[] nums, int target) {
		if(nums == null || nums.length < 2) {
			return new int[] {-1, -1};
		}
		int[] res = new int[] {-1, -1};
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target - nums[i])) {
				res[0] = map.get(target = nums[i]);
				res[1] = i;
				break;
			}
			map.put(nums[i], i);
		}
		return res;
	}

}
