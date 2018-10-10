package com.leetcode.arrays;

/**
 * Created by lhcxx on 18/10/6.
 */
public class FindPeakElement_Leetcode162 {
	public int findPeakElement(int[] nums) {
		int start = 0;
		int end = nums.length - 1;
		while (start + 1 < end) {
			int mid = (start + end) / 2;
			if (nums[mid] > nums[mid + 1])
				end = mid;
			else
				start = mid + 1;
		}
		if (nums[start] > nums[end]) return start;
		return end;
	}
}
