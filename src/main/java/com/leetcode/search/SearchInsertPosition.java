package com.leetcode.search;

public class SearchInsertPosition {
	public int searchInsertPosition(int[] arr, int target) {
		int begin = 0, end = arr.length - 1, mid;
		if (target > arr[end]) return end + 1;
		if (target == arr[end]) return end;
		if (target <= arr[begin]) return 0;

		while (begin <= end) {
			mid = (begin + end) / 2;
			if (target > arr[mid])
				begin = mid + 1;
			else if(target < arr[mid])
				end = mid;
			else
				return mid;
		}
		return begin;
	}
}
