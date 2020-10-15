package leetcode;

import com.leetcode.DFS.MaxAreaOfIsland_695;

import java.util.Arrays;

public class _128_longestConsecutive {
	public int longestConsecutive(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		Arrays.sort(nums);

		int max = 1;
		int cur = 1;
		int last = nums[0];

		for (int i = 1; i < nums.length - 1; i++){
			if (nums[i] == last) continue;
			if (nums[i] == last + 1)
				cur++;
			else {
				max = Math.max(max, cur);
				cur = 1;
			}
			last = nums[i];
		}
		return Math.max(max, cur);
	}
}
