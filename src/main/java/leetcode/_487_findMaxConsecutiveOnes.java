package leetcode;

public class _487_findMaxConsecutiveOnes {
	public int findMaxConsecutiveOnes(int[] nums) {
		if(nums == null || nums.length == 0)
			return 0;
		int count = 0, res = 0;
		for(int l = 0, r = 0; r < nums.length; r++) {
			if(nums[r] == 0) {
				count++;
				while (count > 1) {
					count -= nums[l++] == 0 ? 1 : 0;
				}
			}
			res = Math.max(res, r - l + 1);
		}
		return res;
	}
}
