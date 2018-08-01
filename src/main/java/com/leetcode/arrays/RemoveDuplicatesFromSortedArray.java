package com.leetcode.arrays;

import java.util.Vector;

public class RemoveDuplicatesFromSortedArray {
	public static int removeDuplicates(int[] nums) {
		if (nums.length == 0)
			return 0;
		int index = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[index] != nums[i])
				nums[++index] = nums[i];
		}
		return index + 1;
	}

	public static int removeDuplicatesTwice(int[] nums) {
		if (nums.length <= 2)
			return nums.length;
		int index = 2;
		for (int i = 2; i < nums.length; i++)
			if (nums[i] != nums[index - 2])
				nums[index++] = nums[i];
			return index;
	}


}
