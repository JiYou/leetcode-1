package com.leetcode.arrays;

public class MergeSortedArray_88 {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		if (m < n)
			merge(nums2, n, nums1, m);
		int i = m - 1;
		int j = n - 1;
		int k = m + n - 1;
		while (i >= 0 && j >=0)
			nums1[k--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
		if (i >= 0)
			nums1[k--] = nums1[i--];
	}
}
