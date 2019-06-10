package com.leetcode.arrays;

public class SearchInRotatedSortedArray_81 {
	public boolean search(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return false;
		int start = 0;
		int end = nums.length - 1;
		while (start + 1 < end) {
			int mid = (end - start) / 2 + start;
			if (nums[mid] == target) return true;
			if (nums[mid] == nums[start] && nums[mid] == nums[end]){
				start++;
				end--;
			} else if(nums[mid] >= target) {
				if (target >= nums[start] && target <= nums[mid])
					end = mid;
				else
					start = mid;
			} else {
				if (target >= nums[mid] && target <= nums[end])
					start = mid;
				else
					end = mid;
			}
		}
		if (target == nums[start] || target == nums[end])
			return true;
		return false;
	}
}
