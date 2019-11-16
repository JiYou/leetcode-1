package leetcode;

public class _287_FindtheDuplicateNumber {
	public int findDuplicate(int[] nums) {
		int min = 0, max = nums.length - 1;
		int count = 0;
		while (min <= max) {
			int mid = (max - min) / 2 + min;
			for (int i = 0; i < nums.length; i++)
				if (nums[i] <= mid)
					count++;
			if (count > mid)
				max = mid - 1;
			else
				min = mid + 1;
		}
		return min;
	}
}
