package com.leetcode.DivideAndConuer;

/**
 * Created by lhcxx on 18/9/25.
 */
public class KthLargestElementinanArray_Leetcode215 {
	public int findKthLargest(int[] nums, int k) {
		if (nums == null || nums.length < k)
			return 0;
		int left = 0;
		int right = nums.length - 1;
		while (true) {
			int pos = partition(nums, left, right);
			if (pos + 1 == k)
				return nums[pos];
			else if (pos + 1 > k)
				right = pos - 1;
			else
				left = pos + 1;
		}

	}

	private int partition(int[] nums, int left, int right) {
		int pivot = nums[left];
		int l = left + 1;
		int r = right;
		while (l <= r) {
			if (nums[l] < pivot && pivot < nums[r])
				swap(nums, l++, r--);
			if (nums[l] >= pivot) l++;
			if (nums[r] <= pivot) r--;
		}
		swap(nums, left, r);
		return r;
	}

	private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}
