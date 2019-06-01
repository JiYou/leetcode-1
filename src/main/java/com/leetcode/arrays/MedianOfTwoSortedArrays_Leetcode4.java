package com.leetcode.arrays;

public class MedianOfTwoSortedArrays_Leetcode4 {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		if (nums1.length > nums2.length)
			findMedianSortedArrays(nums2, nums1);

		int len = nums1.length + nums2.length;
		int cut1 = 0, cut2 = 0, cutL = 0, cutR = nums1.length;

		while (cut1 <= nums1.length) {
			cut1 = (cutR + cutL) / 2;
			cut2 = len / 2 - cut1;
			double l1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
			double l2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];
			double r1 = (cut1 == nums1.length) ? Integer.MAX_VALUE : nums1[cut1];
			double r2 = (cut2 == nums2.length) ? Integer.MAX_VALUE : nums2[cut2];
			if (l1 > r2) {
				cutR = cut1 - 1;
			} else if(l2 > r1) {
				cutL = cut1 + 1;
			} else {
				if (len % 2 == 0) {
					l1 = l1 > l2 ? l1 : l2;
					r1 = r1 < r2 ? r1 : r2;
					return (l1 + r1) / 2;
				}
				else{
					r1 = r1 < r2 ? r1 : r2;
					return r1;
				}
			}
		}
		return -1;
	}
}
