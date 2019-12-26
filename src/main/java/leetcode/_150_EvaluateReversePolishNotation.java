package leetcode;

import java.util.Stack;

public class _150_EvaluateReversePolishNotation {
	public int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<>();
		for (String token : tokens) {
			if (token.equals("+"))
				stack.push(stack.pop() + stack.pop());
			else if (token.equals("-")) {
				int a = stack.pop();
				int b = stack.pop();
				stack.push(b - a);
			}else if(token.equals("*")) {
				stack.push(stack.pop() * stack.pop());
			} else if (token.equals("/")) {
				int a = stack.pop();
				int b = stack.pop();
				stack.push(b / a);
			} else
				stack.push(Integer.valueOf(token));
		}
		return stack.pop();
	}
}
