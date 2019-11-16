package leetcode;

import java.util.Random;

public class _384_ShuffleAnArray {

	private int[] nums;
	private Random random;
	public _384_ShuffleAnArray(int[] nums) {
		this.nums = nums;
		random = new Random();
	}

	public int[] shuffle() {
		if (nums == null)
			return null;
		int[] clone = nums.clone();
		for (int i = 1; i < nums.length; i++) {
			int r = random.nextInt(i + 1);
			swap(clone, i, r);
		}
		return clone;
	}

	public int[]reset() {
		return nums;
	}

	private void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}


}
