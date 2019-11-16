package leetcode;

public class _75_SortColors {
	public void sortColors(int[] nums) {
		if (nums == null || nums.length == 0)
			return;
		int l = 0, r = nums.length - 1;
		int index = 0;
		while (l <= r) {
			if (nums[index] == 0)
				swap(nums, l++, index++);
			else if (nums[index] == 1)
				index++;
			else if (nums[index] == 2)
				swap(nums, index, r--);
		}
	}

	private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}
