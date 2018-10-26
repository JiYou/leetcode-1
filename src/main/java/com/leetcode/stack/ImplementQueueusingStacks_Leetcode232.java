package com.leetcode.stack;

import java.util.Stack;

/**
 * Created by lhcxx on 18/10/26.
 */
public class ImplementQueueusingStacks_Leetcode232 {
	Stack<Integer> s1;
	Stack<Integer> s2;

	public ImplementQueueusingStacks_Leetcode232() {
		s1 = new Stack<>();
		s2 = new Stack<>();
	}

	public void push(int a) {
		while (!s1.isEmpty())
			s2.push(s1.pop());
		s2.push(a);
		while (!s2.isEmpty())
			s1.push(s2.pop());
	}

	public Integer pop() {
		return s1.pop();
	}

	public Integer peek() {
		return s1.peek();
	}

	public boolean isEmpty() {
		return s1.isEmpty();
	}
}
