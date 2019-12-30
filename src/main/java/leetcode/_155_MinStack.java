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

	Stack<Integer> s1 = new Stack<>();
	Stack<Integer> minStack = new Stack<>();

	public void push2(int x) {
		s1.push(x);
		if (minStack.isEmpty() || minStack.peek() < x)
			minStack.push(x);
	}

	public void pop2() {
		if (s1.pop() == minStack.peek())
			minStack.pop();
	}

	public int peek2() {
		return s1.peek();
	}

	public int getMin2() {
		return minStack.peek();
	}

}
