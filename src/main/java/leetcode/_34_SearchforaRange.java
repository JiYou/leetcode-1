package leetcode;

public class _34_SearchforaRange {
	public int[] searchRange(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return new int[] {-1, -1};
		int start = findFirst(nums, target);
		if (start == -1)
			return new int[] {-1, -1};
		int end = findLast(nums, target);
		return new int[] {start, end};
	}

	public int findFirst(int[] nums, int target) {
		int start = 0, end = nums.length - 1;
		while (start + 1 < end) {
			int mid = (end - start) / 2 + start;
			if (nums[mid] < target)
				start = mid;
			else
				end = mid;
		}
		if (nums[start] == target)
			return start;
		return -1;
	}

	public int findLast(int[] nums, int target) {
		int start = 0, end = nums.length - 1;
		while (start + 1 < end) {
			int mid = (end - start) / 2 + start;
			if (nums[mid] > target)
				end = mid;
			else
				start = mid;
		}
		if (nums[end] == target)
			return end;
		return -1;
	}

	public int[] searchRange2(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return new int[] {-1, -1};
		int start = 0, end = nums.length - 1;
		while (start <= end) {
			int mid = (end - start) / 2 + start;
			if (nums[mid] > target)
				end = mid - 1;
			else if (nums[mid] < target)
				start = mid + 1;
			else {
				while (nums[start] != target) start++;
				while (nums[end] != target) end--;
				return new int[] {start, end};
			}
		}
		return new int[] {-1, -1};
	}
}
