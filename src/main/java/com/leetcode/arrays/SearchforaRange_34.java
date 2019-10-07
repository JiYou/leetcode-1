package com.leetcode.arrays;

public class SearchforaRange_34 {


	public int[] searchRange(int[] nums, int target) {
		int[] res = new int[] {-1, -1};
		if (nums == null || nums.length == 0)
			return res;
		int left = binarySearch(nums, target - 0.5);
		int right = binarySearch(nums, target + 0.5);
		res[0] = left;
		res[1] = right - 1;
		return res;
	}

	private int binarySearch(int[] nums, double target) {
		int begin = 0, end = nums.length - 1;
		while (begin <= end) {
			int mid = (end - begin) / 2 + begin;
			if (target > nums[mid])
				begin = mid + 1;
			else
				end = mid - 1;
		}
		return begin;
	}
}
