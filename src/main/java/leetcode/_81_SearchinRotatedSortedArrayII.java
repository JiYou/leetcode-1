package leetcode;

public class _81_SearchinRotatedSortedArrayII {
	public boolean search(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;
		while (start < end) {
			int mid = (end - start) / 2 + start;
			if (nums[mid] == target)
				return true;
			if (nums[mid] == nums[start] && nums[mid] == nums[end]) { // 1 0 1 1   1 1 1 0 1
				start++;
				end--;
			} else if (nums[mid] >= nums[start]) {
				if (nums[start] <= target && target <= nums[mid])
					end = mid;
				else
					start = mid;
			} else {
				if (nums[mid] <= target && target <= nums[end])
					start = mid;
				else
					end = start;
			}
		}
		if (nums[start] == target)
			return true;
		if (nums[end] == target)
			return true;
		return false;
	}
}
