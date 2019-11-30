package leetcode;

import java.util.Stack;

public class _155_MinStack {
	Stack<Integer> stack;
	int min;

	public _155_MinStack() {
		stack = new Stack<>();
		min = Integer.MAX_VALUE;
	}

	public void push(int x) {
		if (x <= min) {
			stack.push(min);
			min = x;
		}
		stack.push(x);
	}

	public void pop() {
		if (min == stack.pop())
			min = stack.pop();
	}

	public int getTop() {
		return stack.peek();
	}

	public int getMin() {
		return min;
	}
}
