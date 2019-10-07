package com.leetcode.DP;

public class JumpGame_55 {

	// DP solution o(n*n) o(n)
	public boolean canJump(int[] nums){
		int n = nums.length;
		boolean[] f = new boolean[n];
		f[0] = true;

		for (int i = 1; i < n; i++) {
			f[i] = false;
			for (int j = 0; j < i; j++) {
				if (f[j] && (nums[j] + j) > nums[i]){
					f[j] = true;
					break;
				}
			}
		}
		return f[n - 1];
	}

	//greedy
	public boolean canJump2(int[] nums) {
		int max = 0;
		for (int i = 0; i< nums.length; i++) {
			if (i > max)
				return false;
			max = Math.max(max, nums[i] + i);
		}
		return true;
	}

	public boolean canJump3(int[] nums) {
		boolean[] res = new boolean[nums.length + 1];
		res[0] = true;
		for (int i = 1; i < nums.length; i++) {
			res[i] = false;
			for (int j = 0; j < i; j++)
				if (res[j] && nums[j] + j >= nums[i]) {
					res[j] = true;
					break;
				}
		}
		return res[nums.length - 1];
	}

	public boolean canJump4(int[] nums) {
		int max = 0;
		for (int i = 0; i < nums.length; i++) {
			if (i > max) return false;
			max = Math.max(nums[i] + i, max);
		}
		return true;
	}
}
