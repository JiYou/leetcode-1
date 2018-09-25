package com.leetcode.arrays;

import com.leetcode.utils.Utils;

/**
 * Created by lhcxx on 18/9/26.
 */
public class SortColors_Leetcode75 {
	public void sortColors(int[] nums) {
		if (nums == null || nums.length == 0)
			return;

		int left = 0, right = nums.length - 1, index = 0;
		while (nums[index] <= right) {
			if (index == 0)
				Utils.swap(nums, left++, index++);
			else if (nums[index] == 1)
				index++;
			else
				Utils.swap(nums, index, right--);
		}
	}
}
