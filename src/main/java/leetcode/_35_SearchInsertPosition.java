package leetcode;

public class _35_SearchInsertPosition {
	public int searchInsert(int[] nums, int target) {
		int len = nums.length;
		if (len == 0)
			return -1;
		if (nums[len - 1] < target)
			return len;

		int left = 0;
		int right = nums.length - 1;

		while (left < right) {
			int mid = (right - left) / 2 + left;
			if (nums[mid] == target)
				return mid;
			else if (nums[mid] < target)
				left = mid + 1;
			else
				right = mid;
		}
		return right;
	}
}
