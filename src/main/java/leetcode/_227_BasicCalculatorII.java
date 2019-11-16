package leetcode;

import java.util.Stack;

public class _227_BasicCalculatorII {
	public int calculate(String s) {
		if (s == null || s.length() == 0)
			return 0;
		Stack<Integer> stack = new Stack<>();
		int res = 0;
		char sign = '+';
		int num = 0;
		for (int i = 0; i < s.length(); i++) {
			if (Character.isDigit(s.charAt(i))) {
				num = s.charAt(i) - '0';
				while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
					num = num * 10 + s.charAt(i + 1) - '0';
					i++;
				}
			}
			if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == s.length() - 1) {
				if (sign == '+') stack.push(num);
				if (sign == '-') stack.push(-num);
				if (sign == '*') stack.push(stack.pop() * num);
				if (sign == '/') stack.push(stack.pop() / num);
				sign = s.charAt(i);
				num = 0;
			}
		}
		for (int i : stack)
			res += i;
		return res;
	}

	public int calculate2(String s) {
		if (s == null || s.length() == 0) return 0;
		s = s.trim().replaceAll(" +", "");
		int res = 0;
		char sign = '+';
		int pre = 0;
		for (int i = 0; i < s.length(); i++) {
			  int cur = 0;
				while (i < s.length() && Character.isDigit(s.charAt(i))){
					cur = cur * 10 + s.charAt(i) - '0';
					i++;
				}
				if (sign == '+') {
					res += pre;
					pre = cur;
				} else if (sign == '-') {
					res += pre;
					pre = - cur;
				} else if(sign == '*') {
					pre = pre * cur;
				} else if (sign == '/') {
					pre = pre / cur;
				}
				if (i < s.length()) {
					sign = s.charAt(i);
					i++;
				}
		}
		res += pre;
		return res;
	}

}
