package leetcode;

public class _287_FindtheDuplicateNumber {
	public int findDuplicate(int[] nums) {
		int min = 1, max = nums.length;
		int count = 0;
		while (min < max) {
			int mid = (max - min) / 2 + min;
			for (int i = 0; i < nums.length; i++)
				if (nums[i] <= mid)
					count++;
			if (count > mid)
				max = mid - 1;
			else
				min = mid;
		}
		return max;
	}
}
