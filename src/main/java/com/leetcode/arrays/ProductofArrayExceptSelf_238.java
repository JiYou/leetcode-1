package com.leetcode.arrays;

public class ProductofArrayExceptSelf_238 {
	public int[] productExceptSelf(int[] nums) {
		if (nums == null || nums.length == 0)
			return nums;
		int[] res = new int[nums.length];
		res[0] = 1;
		for (int i = 1; i < nums.length; i++) {
			res[i] = res[i - 1] * nums[i - 1];
		}
		int right = 1;
		for (int i = nums.length - 1; i >= 0; i--){
			res[i] *= right;
			right *= nums[i];
		}
		return res;
	}

	public int[] productExceptSelf2(int[] nums) {
		if (nums == null || nums.length == 0)
			return nums;
		int[] res = new int[nums.length];
		res[0] = 1;
		for (int i = 1; i < nums.length; i++){
			res[i] = res[i - 1] * nums[i - 1];
		}
		int right = 1;
		for (int i = nums.length - 1; i >= 0; i--) {
			res[i] *= right;
			right *= nums[i];
		}
		return res;
	}
}
