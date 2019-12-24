package leetcode;

public class _713_NumSubarrayProductLessThanK {
	public int numSubarrayProductLessThanK(int[] nums, int k) {
		if (k <= 1)
			return 0;
		int cur = 1, left = 0, times = 0;

		for (int right = 0; right < nums.length; right++) {
			cur *= nums[right];
			while (cur >= k) cur /= nums[left++];
			times += right - left + 1;
		}

		return times;
	}
}
