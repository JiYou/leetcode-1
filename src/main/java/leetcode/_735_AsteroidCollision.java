package leetcode;

import java.util.Stack;

public class _735_AsteroidCollision {
	public int[] asteroidCollision(int[] asteroids) {
		Stack<Integer> stack = new Stack<>();
		for (int n : asteroids) {
			if (stack.isEmpty())
				stack.push(n);
			else {
				if (stack.peek() < 0 || (stack.peek() > 0 && n > 0))
					stack.push(n);
				else if (stack.peek() > 0 && n < 0) {
					int abs_peek = Math.abs(stack.peek());
					int abs_n = Math.abs(n);
					if (abs_n == abs_peek)
						stack.pop();
					else if (abs_n > abs_peek) {
						stack.pop();
						stack.push(n);
						while (stack.peek() < 0 && stack.size() >= 2) {
							int first = stack.pop();
							int second = stack.pop();
							if (second < 0) {
								stack.push(second);
								stack.push(first);
								break;
							}
							if (Math.abs(first) == Math.abs(second)) {
								break;
							}
							stack.push(Math.abs(first) > Math.abs(second) ? first : second);
						}
					}
				}
			}
		}
		int size = stack.size();
		int[] res = new int[size];
		for (int i = size - 1; i >= 0; i--)
			res[i] = stack.pop();
		return res;
	}
}
