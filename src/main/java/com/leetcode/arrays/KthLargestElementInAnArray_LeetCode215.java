package com.leetcode.arrays;

import java.util.PriorityQueue;

public class KthLargestElementInAnArray_LeetCode215 {
	private static int partition(int[] nums, int left, int right) {
		int pivot = nums[left];
		int l = left;
		int r = right;
		while (l <= r) {
			while (l <= r && nums[r] >= pivot)
				r--;
			nums[l] = nums[r];
			while (l <= r && nums[l] <= pivot)
				l++;
			nums[r] = nums[l];
		}
		nums[l] = pivot;
		return l;
	}

	public static int findKthInArray(int[] nums, int k) {
		if (nums == null || nums.length < k) return 0;
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

	public int findKth(int[] nums, int k) {
		if (nums == null || nums.length < k) return 0;
		PriorityQueue<Integer> p = new PriorityQueue<>();
		for (int i = 0; i < nums.length; i++) {
			p.add(nums[i]);
			if (p.size() > k)
				p.poll();
		}
		return p.poll();
	}


}
