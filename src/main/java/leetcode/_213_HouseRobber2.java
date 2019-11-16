package leetcode;

public class _213_HouseRobber2 {


	public int rob(int[] nums) {
		if (nums.length == 1)
			return nums[0];
		int n = nums.length;
		return Math.max(rob(nums, 0, n - 2), rob(nums, 1, n - 1));
	}

	public int rob(int[] nums, int lo, int hi) {
		int prevNo = 0;
		int curYes = 0;
		for (int i = lo; i <= hi; i++) {
			int tmp = prevNo;
			prevNo = Math.max(prevNo, curYes);
			curYes = nums[i] + tmp;
		}
		return Math.max(prevNo, curYes);
	}
}
