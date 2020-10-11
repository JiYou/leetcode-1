package leetcode;

import java.util.Arrays;

public class _462_minMoves2 {
	public int minMoves2(int[] nums) {
		Arrays.sort(nums);
		int sum = 0;
		for (int num : nums) {
			sum += Math.abs(nums[nums.length / 2] - num);
		}
		return sum;
	}

	public int minMoves2_2(int[] nums) {
		int sum = 0;
		int median = select(nums, 0, nums.length - 1, nums.length / 2);

		for (int num : nums)
			sum += Math.abs(median - num);
		return sum;
	}

	public int partition(int[] arr, int left, int right) {
		int pivot = arr[left];
		while (left < right) {
			while (left < right && arr[right] > pivot)
				right--;
			arr[left] = arr[right];
			while (left < right && arr[left] > pivot)
				left++;
			arr[right] = arr[left];
		}
		arr[left] = pivot;
		return left;
	}

	private int select(int[] list, int left, int right, int k) {
		if (left == right)
			return list[right];
		int pivot = partition(list, left, right);
		if (pivot == k) {
			return list[k];
		} else if (pivot > k)
			return select(list, left, pivot - 1, k);
		else
			return select(list, pivot + 1, right, k);
	}

}
