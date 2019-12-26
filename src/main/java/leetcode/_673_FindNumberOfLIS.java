package leetcode;

import java.util.Arrays;

public class _673_FindNumberOfLIS {
	public int findNumberOfLIS(int[] nums) {
		int n = nums.length;
		if (n <= 1)
			return n;

		int[] lengths = new int[n];
		int[] counts = new int[n];
		Arrays.fill(counts, 1);

		for (int i = 0; i < n; i++)
			for (int j = 0; j < i; j++)
				if (nums[j] < nums[i]) {
					if(lengths[j] >= lengths[i]) {
						lengths[i] = lengths[j] + 1;
						counts[i] = counts[j];
					} else if (lengths[j] + 1 == lengths[i]) {
						counts[i] += counts[j];
					}
				}
		int longest = 0, ans = 0;
		for (int length : lengths)
			longest = Math.max(longest, length);
		for (int i = 0; i < n; i++)
			if (lengths[i] == longest)
				ans += counts[i];
		return ans;
	}
}
