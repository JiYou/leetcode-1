package leetcode;

public class _162_FindPeakElement {
	public int findPeakElement(int[] nums) {
		int start = 0, end = nums.length - 1;
		while (start <= end) {
			int mid = (end - start) / 2 + start;
			if (nums[mid] > nums[mid + 1])
				end = mid;
			else
				start = mid + 1;
		}
		return start;
	}

	public int findPeakElement2(int[] nums) {
		for (int i = 0; i < nums.length; i++)
			if (nums[i] > nums[i + 1])
				return i;
		return nums.length - 1;
	}
}
