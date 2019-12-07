package leetcode;

public class _540_SingleNonDuplicate {
	public int singleNonDuplicate(int[] nums) {
		int l = 0, r = nums.length - 1;
		while (l < r) {
			int mid = (r - l) / 2 + l;
			if (mid % 2 == 1) {
				if (nums[mid] == nums[mid + 1])
					r = mid - 1;
				else
					l = mid + 1;
			} else {
				if (nums[mid] == nums[mid + 1])
					l = mid + 2;
				else
					r = mid;
			}
		}
		return nums[l];
	}
}
