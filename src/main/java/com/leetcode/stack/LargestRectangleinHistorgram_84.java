package com.leetcode.stack;

import java.util.Stack;

public class LargestRectangleinHistorgram_84 {
	public int LargestRectangleinHistorgram(int[] heights) {
		if (heights == null || heights.length == 0) return 0;
		Stack<Integer> stack = new Stack<>();
		int res = 0;
		for (int i = 0; i <= heights.length; i++) {
			int cur = i == heights.length ? 0 : heights[i];
			while (!stack.isEmpty() && cur < heights[stack.peek()]) {
				int h = heights[stack.pop()];
				int start = stack.isEmpty() ? -1 : stack.peek();
				int ares = h * (i - start - 1);
				res = Math.max(res, ares);
			}
			stack.push(i);
		}
		return res;
	}
}
