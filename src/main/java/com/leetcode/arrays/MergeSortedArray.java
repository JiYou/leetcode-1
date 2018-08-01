package com.leetcode.arrays;

public class MergeSortedArray {
	public static void merge(int[] a, int[] b) {
		int ia = a.length - 1, ib = b.length - 1, icur = a.length + b.length - 1;
		while (ia >= 0 && ib >=0)
			a[icur--] = a[ia] > b[ib] ? a[ia--] : b [ib--];
		while (ib >= 0)
			a[icur--] = b[ib--];
	}
}
