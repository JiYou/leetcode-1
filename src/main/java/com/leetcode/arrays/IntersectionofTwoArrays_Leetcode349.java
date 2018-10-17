package com.leetcode.arrays;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by lhcxx on 18/10/11.
 */
public class IntersectionofTwoArrays_Leetcode349 {
	public int[] intersection(int[] s, int[] t) {
		if (s == null || t == null || s.length == 0 || t.length == 0)
			return new int[]{};
		HashSet<Integer> set = new HashSet<>();
		Arrays.sort(t);
		for (int num : s) {
			if (binarySearch(t, num))
				set.add(num);
		}
		int[] res = new int[set.size()];
		int k = 0;
		for (int num : set) {
			res[k++] = num;
		}
		return res;
	}

	private boolean binarySearch(int[] a, int k) {
		if (a == null || a.length == 0)
			return false;
		int start = 0, end = a.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (a[mid] == k)
				return true;
			else if (a[mid] > k)
							end = mid - 1;
			else
				start = mid + 1;
		}
		return false;
	}

	public int[] intersection2(int[] s, int[] t) {
		if (s == null || t == null || s.length == 0 || t.length == 0)
			return new int[]{};
		Arrays.sort(s);
		Arrays.sort(t);
		HashSet<Integer> set = new HashSet<>();
		int i = 0, j = 0;
		while (i < s.length && j < t.length) {
			if (s[i] < t[j])
				i++;
			else if (s[i] > t[j])
				j++;
			else {
				set.add(s[i]);
				i++;
				j++;
			}
		}
		int k = 0;
		int[] res = new int[set.size()];
		for (int num : set) {
			res[k++] = num;
		}
		return res;
	}
}
