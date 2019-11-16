package leetcode;

public class _153_FindMinimuminRotatedSortedArray {
	public int findMin(int[] nums) {
		if (nums == null || nums.length == 0)
			return -1;
		int l = 0, r = nums.length - 1;

		while (l <= r) {
			int mid = (r - l) / 2 + l;
			if (nums[mid] < nums[r])
				r = mid;
			else
				l = mid + 1;
		}
		if (nums[l] < nums[r])
			return nums[l];
		else
			return nums[r];
	}
}
