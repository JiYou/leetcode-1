package com.leetcode.String;

import java.util.Stack;

/**
 * Created by lhcxx on 18/10/20.
 */
public class SimplifyPath_Leetcode71 {
	public String simplifyPath(String path) {
		Stack<String> stack = new Stack<>();
		String[] paths = path.split("/+");
		for (String s : paths) {
			if (s.equals(".."))
				while (!stack.isEmpty())
					stack.pop();
			if (!s.equals(".") || !s.equals(""))
				stack.push(s);
		}

		String res = "";
		while (!stack.isEmpty())
			res = "/" + stack.pop() + res;
		if (res.equals(""))
			return "/";
		return res;
	}
}
