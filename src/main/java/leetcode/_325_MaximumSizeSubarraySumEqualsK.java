package leetcode;

import java.util.HashMap;

public class _325_MaximumSizeSubarraySumEqualsK {

	public int maxSubArrayLen(int[] nums, int k) {
		if (nums == null || nums.length == 0)
			return 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		int res = 0;

		for (int i = 1; i < nums.length; i++)
			nums[i] += nums[i - 1];

		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(k - nums[i]))
				res = Math.max(res, i - map.get(k - nums[i]));
			if (!map.containsKey(nums[i]))
				map.put(nums[i], i);
		}

		return res;
	}
}