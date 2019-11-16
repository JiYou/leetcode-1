package leetcode;

import java.util.Stack;

public class _394_DecodeString {
	public String decodeString(String s) {
		if (s == null || s.length() == 0)
			return s;
		String res = "";
		Stack<Integer> count = new Stack<>();
		Stack<String> stack = new Stack<>();
		int i = 0;
		while (i < s.length()) {
			if (Character.isDigit(s.charAt(i))) {
				int num = 0;
				while (Character.isDigit(s.charAt(i))) {
					num = num * 10 + s.charAt(i) - '0';
					i++;
				}
				count.push(num);
			} else if (s.charAt(i) == '[') {
				stack.push(res);
				res = "";
				i++;
			} else if (s.charAt(i) == ']') {
				StringBuffer sb = new StringBuffer(stack.pop());
				int times = count.pop();
				for (int j = 0; j < times; j++) {
					sb.append(res);
				}
				res = sb.toString();
				i++;
			} else {
				res += s.charAt(i++);
			}
		}
		return res;
	}
}
