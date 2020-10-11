package leetcode;

import com.leetcode.DFS.MaxAreaOfIsland_695;

import java.util.Arrays;

public class _128_longestConsecutive {
	public int longestConsecutive(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		Arrays.sort(nums);

		int max = 0;
		int cur = 1;

		for (int i = 0; i < nums.length - 1; i++){
			if (nums[i] + 1 == nums[i + 1])
				cur++;
			else {
				max = Math.max(max, cur);
				cur = 1;
			}
		}
		return Math.max(max, cur);
	}
}
