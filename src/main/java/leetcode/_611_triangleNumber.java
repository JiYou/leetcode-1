package leetcode;

import java.util.Arrays;

public class _611_triangleNumber {
	public int triangleNumber(int[] nums) {
		int count = 0;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			int k = i + 2;
				for (int j = i + 1; j < nums.length - 1 && nums[i] != 0; j++) {
					k = binarySearch(nums, k, nums.length - 1, nums[i] + nums[j]);
					count += k - j - 1;
				}
		}
		return count;
	}

	private int binarySearch(int[] nums, int l ,int r, int x) {
		while (l <= r && r < nums.length) {
			int mid = (r - l) / 2 + l;
			if (nums[mid] >= x)
				r = mid - 1;
			else
				l = mid + 1;
		}
		return l;
	}
}
