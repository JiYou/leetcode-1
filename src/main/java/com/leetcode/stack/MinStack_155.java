package com.leetcode.stack;

import java.util.Stack;

public class MinStack_155 {
	private Stack<Integer> stack;
	private Stack<Integer> min;

	MinStack_155() {
		stack = new Stack<>();
		min = new Stack<>();
	}

	public void push(int a) {
		stack.push(a);
		if (!min.isEmpty()) {
			if (a < min.peek())
				min.push(a);
		} else
			min.push(a);
	}

	public void pop() {
		int a = stack.pop();
		if (a == min.peek())
			min.pop();
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return min.peek();
	}
}
