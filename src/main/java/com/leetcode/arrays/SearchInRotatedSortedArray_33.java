package com.leetcode.arrays;

public class SearchInRotatedSortedArray_33 {
	public int search(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return -1;
		int start = 0;
		int end = nums.length - 1;
		while (start <= end) {
			int mid = (end - start) / 2 + start;
			if (nums[mid] == target)
				return mid;

			if(nums[mid] >= nums[start]) {
				if (target > nums[start] && target < nums[mid]){
					end = mid - 1;
 				} else
 					start = mid + 1;
			}

			if (nums[mid] <= nums[end]) {
				if (target >= nums[mid] && target <= nums[end]) {
					start = mid + 1;
				} else
					end = mid - 1;
			}
		}
		return -1;
	}

	public int search2(int[]nums, int target) {
		if (nums == null || nums.length == 0)
			return -1;
		int start = 0;
		int end = nums.length - 1;
		while (start <= end) {
			int mid = (end - start) / 2 + start;
			if (nums[mid] == target)
				return mid;
			if (nums[mid] >= nums[start]) {
				if (target <= nums[mid] && target >= nums[start]) {
					end = mid -1;
				}
				else
					start = mid + 1;
			}

			if (nums[mid] <= nums[end]) {
				if (target > nums[mid] && target <= nums[end])
					start = mid + 1;
				else
					end = mid - 1;
			}
		}
		return -1;
	}
}
