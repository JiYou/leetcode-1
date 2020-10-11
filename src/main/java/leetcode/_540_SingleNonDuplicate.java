package leetcode;

public class _540_SingleNonDuplicate {
	public int singleNonDuplicate(int[] nums) {
		int l = 0;
		int r = nums.length - 1;
		while (l < r) {
			int mid = l + (r-l) / 2;
			if (mid % 2 == 1)
				mid -= 1;
			if (nums[mid] == nums[mid + 1])
				l = mid + 2;
			else
				r = mid;
		}
		return nums[l];

	}
}
