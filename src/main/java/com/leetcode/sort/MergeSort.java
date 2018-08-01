package com.leetcode.sort;

public class MergeSort {
	private static void merge(int[] arr, int left, int mid, int right) {
		int[] tmp = new int[right - left + 1];
		int i = left;
		int j = mid + 1;
		int k = 0;
		while (i <= mid && j <= right) {
			if (arr[i] < arr[j])
				tmp[k++] = arr[i++];
			else
				tmp[k++] = arr[j++];
		}
		while (i <= mid)
			tmp[k++] = arr[i++];
		while (j <= right)
			tmp[k++] = arr[j++];

		for (int p = 0; i < tmp.length; p++)
			arr[left + p] = tmp[p];
	}

	private static void mergeSort(int[] arr, int left, int right) {
		if (left > right)
			return;

		int mid = (left + right) / 2;
		mergeSort(arr, left, mid);
		mergeSort(arr, mid + 1, right);
		merge(arr, left, mid, right);
	}

	public static void sort(int[] arr) {
		mergeSort(arr, 0, arr.length - 1);
	}
}



