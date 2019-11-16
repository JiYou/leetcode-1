package leetcode;

public class _198_HouseRobber {
	public int rob(int[] nums) {
		int prevNo = 0;
		int curYes = 0;
		for (int num : nums) {
			int tmp = prevNo;
			prevNo = Math.max(prevNo, curYes);
			curYes = num + tmp;
		}
		return Math.max(prevNo, curYes);
	}
}
