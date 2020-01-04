package leetcode;

import java.util.Arrays;

public class _324_WiggleSortII {
	public void wiggleSort(int[] nums) {
		Arrays.sort(nums);
		int n = nums.length;
		int mid = (n) / 2;
		int index = 0;
		int[] tmp = new int[n];
		for (int i = 0; i <= mid; i++) {
			tmp[index] = nums[mid - i];
			if (index + 1 < n)
				tmp[index + 1] = nums[n - 1 - i];
			index += 2;
		}
		System.arraycopy(tmp, 0, nums, 0, n);
	}
}
