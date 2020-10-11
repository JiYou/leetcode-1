package leetcode;

import java.util.Arrays;

public class _259_ThreeSumSmaller {
	public int threeSumSmaller(int[] nums, int target) {
		int res = 0;
		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 2; i++) {
			int left = i + 1;
			int right = nums.length - 1;
			while (left < right) {
				int sum = nums[i] + nums[left] + nums[right];
				if (sum < target) {
					res += right - left;
					left++;
				} else
					right--;
			}
		}
		return res;
	}
}
