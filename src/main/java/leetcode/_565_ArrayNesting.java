package leetcode;

public class _565_ArrayNesting {
	public int arrayNesting(int[] nums) {
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			int count = 0, next = i;
			while (nums[next] != -1) {
				count++;
				int tmp = next;
				next = nums[next];
				nums[tmp] = -1;
			}
			res = Math.max(res, count);
		}
		return res;
	}
}
