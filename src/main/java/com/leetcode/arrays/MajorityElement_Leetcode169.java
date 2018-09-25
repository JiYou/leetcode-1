package com.leetcode.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lhcxx on 18/9/25.
 */
public class MajorityElement_Leetcode169 {
	public int majorityElement(int[] nums){
		Map<Integer,Integer> map = new HashMap<>();
		int res = 0;
		for (int num : nums) {
			if (!map.containsKey(num))
				map.put(num, 1);
			else
				map.put(num, map.get(num) + 1);
			if (map.get(num) > nums.length / 2) {
				res = num;
				break;
			}
		}
		return res;
	}

	public int majorityElement2(int[] nums) {
		int count = 0;
		int res = 0;
		for (int num : nums) {
			if (count == 0)
				res = num;
			if (num != res)
				count--;
			else count++;
		}
		return res;
	}

}
