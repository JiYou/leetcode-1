package com.leetcode.sort;

public class QuickSort {
	private static int partition(int[] nums, int left, int right) {
		int i = left;
		int j = right;
		int key = nums[left];

		while (i < j) {
			while (nums[j] >= key && j > i)
				j--;
			if (j > i) {
				nums[i++] = nums[j];
			}
			while (nums[i] <= key && i < j)
				i++;
			if (i < j){
				nums[j--] = nums[i];
			}

		}
		nums[i] = key;
		return i;
	}

	public static int partition2(int[] arr, int left, int right) {
		int pivotKey = arr[left];

		while(left < right) {
			while(left < right && arr[right] >= pivotKey)
				right --;
			arr[left] = arr[right]; //把小的移动到左边
			while(left < right && arr[left] <= pivotKey)
				left ++;
			arr[right] = arr[left]; //把大的移动到右边
		}
		arr[left] = pivotKey; //最后把pivot赋值到中间
		return left;
	}

	private static void quickSort(int[] nums, int left, int right) {
		if (right > left) {
			int key = partition2(nums, left, right);
			quickSort(nums, left, key - 1);
			quickSort(nums, key + 1, right);
		}
	}

	public static void sort(int[] nums) {
		quickSort(nums, 0, nums.length - 1);
	}


}
