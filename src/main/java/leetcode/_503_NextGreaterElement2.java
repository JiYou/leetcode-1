package leetcode;

import java.util.Arrays;
import java.util.Stack;

public class _503_NextGreaterElement2 {
	public int[] nextGreaterElement(int[] nums) {
		int[] res = new int[nums.length];
		Arrays.fill(res, -1);
		Stack<Integer> stack = new Stack<>();
		int len = nums.length;
		for (int i = 0; i < len * 2; i++) {
			int num = nums[i % len];
			while (!stack.isEmpty() && nums[stack.peek()] < num)
				res[stack.pop()] = num;
			if (i < len)
				stack.push(i);
		}
		return res;
	}
}
