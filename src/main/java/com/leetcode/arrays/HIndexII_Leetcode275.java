package com.leetcode.arrays;

/**
 * Created by lhcxx on 18/9/26.
 */
public class HIndexII_Leetcode275 {
	public int hIndex(int[] nums) {
		int len = nums.length;
		int start = 0, end = len - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (nums[mid]  == len - mid)
				return len - mid;
			else if (nums[mid] < len - mid)
				start = mid + 1;
			else
				end = mid - 1;
		}
		return len - start;
	}

}
