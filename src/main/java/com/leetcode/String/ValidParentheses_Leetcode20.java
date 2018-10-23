package com.leetcode.String;

import java.util.Stack;

/**
 * Created by lhcxx on 18/10/20.
 */
public class ValidParentheses_Leetcode20 {
	public boolean isValid(String s) {
		if (s == null || s.length() == 0)
			return true;
		Stack<Character> stack = new Stack<>();
		for(Character ch : s.toCharArray()) {
			if (ch == '(')
				stack.push(')');
			else if (ch == '{')
				stack.push('}');
			else if (ch == '[')
				stack.push(']');
			else if (stack.isEmpty() || stack.pop() != ch)
				return false;
		}
		return stack.isEmpty();
	}
}
