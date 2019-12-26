package leetcode;

import java.util.Random;

public class _398_RandomPickIndex {
	private int[] nums;
	private Random rdm;

	public _398_RandomPickIndex(int[] nums){
		this.nums = nums;
		rdm = new Random();
	}

	public int pick(int target) {
		int res = -1;
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != target)
				continue;
			if (rdm.nextInt(++count) == 0)
				res = i;
		}
		return res;
	}
}
