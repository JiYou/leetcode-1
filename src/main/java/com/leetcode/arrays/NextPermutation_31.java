package com.leetcode.arrays;

public class NextPermutation_31 {


	public void nextPermutation(int[] nums) {
		if (nums == null || nums.length == 0)
			return;
		int start = -1;
		for (int i = nums.length - 2; i >= 0; i--)
			if (nums[i] < nums[i + 1]) {
				start = i;
				break;
			}
		if (start == -1) {
			reverse(nums, 0, nums.length - 1);
			return;
		}

		int end = -1;
		for (int i = nums.length - 1; i > start; i--)
			if (nums[i] > nums[start]) {
				end = i;
				break;
			}
		swap(nums, start, end);
		reverse(nums, start + 1, end - 1);
		return;
	}


	private void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}

	private void reverse(int[] a, int i, int j) {
		while (i < j) {
			swap(a, i++, j--);
		}
	}
}
