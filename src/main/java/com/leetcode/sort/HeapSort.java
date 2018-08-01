package com.leetcode.sort;

import com.leetcode.utils.Utils;

public class HeapSort {
	public static void heapAdjust(int[] arr, int start, int end) {
		int tmp = arr[start];
		for (int i = 2 * start + 1; i <= end; i *= 2) {
			if (i < end && arr[i] < arr[i + 1]){
				i++;
			}
			if (tmp >= arr[i])
				break;
			arr[start] = arr[i];
			start = i;
		}
		arr[start] = tmp;
	}

	public static void heapSort(int[] arr) {
		if (arr == null || arr.length == 0)
			return;
		for (int i = arr.length / 2; i >= 0; i--)
			heapAdjust(arr, i, arr.length - 1);
		for (int i = arr.length - 1; i >= 0; i --){
			Utils.swap(arr, 0, i);
			heapAdjust(arr, 0, i - 1);
		}
	}


}
