package com.leetcode.arrays;

public class MedianOfTwoSortedArrays_Leetcode4 {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		if (nums1.length > nums2.length)
			findMedianSortedArrays(nums2, nums1);

	}
}
