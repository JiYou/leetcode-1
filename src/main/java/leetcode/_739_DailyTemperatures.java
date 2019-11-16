package leetcode;

import java.util.List;
import java.util.Stack;

public class _739_DailyTemperatures {
	public int[] dailyTemperatures(int[] nums) {
		int[] res = new int[nums.length];
		Stack<Integer> stack = new Stack<>();
		for (int i = nums.length - 1; i >= 0; i--) {
			while (!stack.isEmpty() && nums[i] > nums[stack.peek()])
				stack.pop();
			if (stack.isEmpty())
				res[i] = 0;
			else
				res[i] = stack.peek() - i;
			stack.push(nums[i]);
		}
		return res;
	}
}
