package leetcode;

public class _209_MinimumSizeSubarraySum {
	public int minSubArrayLen(int s, int[] nums) {
		int sum = 0;
		int res = Integer.MAX_VALUE;
		int left = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			while (left < nums.length && sum >= s) {
				res = Math.min(res, i - left + 1);
				sum -= nums[left++];
			}
		}
		return res == Integer.MAX_VALUE? 0:res;
	}
}
