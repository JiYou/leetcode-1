package leetcode;

import java.util.Stack;

public class _402_RemoveKDigits {
	public String removeKDigits(String num, int k) {
		if (k == num.length())
			return "0";
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < num.length(); i++) {
			while (!stack.isEmpty() && k > 0 && stack.peek() > num.charAt(i)) {
				stack.pop();
				k--;
			}
			stack.push(num.charAt(i));
		}

		while (k > 0) {
			stack.pop();
			k--;
		}

		StringBuffer sb = new StringBuffer();

		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		sb.reverse();

		int index = 0;
		while (index < num.length() && sb.charAt(index) == '0')
			index++;

		return index != sb.length()? sb.substring(index) : "0";
	}
}
