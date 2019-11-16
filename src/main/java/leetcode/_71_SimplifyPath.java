package leetcode;

import java.util.Stack;

public class _71_SimplifyPath {
	public String simplifyPath(String path) {
		Stack<String> stack = new Stack<>();
		String[] paths = path.split("/+");
		for (String str : paths) {
			if (str.equals(".."))
				stack.pop();
			else if (!str.equals(".") && !str.equals(""))
				stack.push(str);
		}
		String res = "";
		while (!stack.isEmpty()) {
			res = "/" + stack.pop() + res;
		}
		if (res.length() == 0)
			return "/";
		return res;
	}
}
