package com.leetcode.hash;

import java.util.HashMap;

public class FIndAnagramMapping_Leetcode760 {
	public int[] anagramMapping(int[] a, int[] b) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < b.length; i++)
			map.put(b[i], i);
		int[] res = new int[a.length];
		int index = 0;
		for (int num : a)
			res[index++] = map.get(num);
		return res;
	}
}
