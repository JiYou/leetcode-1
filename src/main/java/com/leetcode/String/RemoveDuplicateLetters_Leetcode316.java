package com.leetcode.String;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by lhcxx on 18/10/11.
 */
public class RemoveDuplicateLetters_Leetcode316 {
	public String removeDuplicateLetters(String s) {
		if (s == null || s.length() == 0) return s;
		int[] freq = new int[256];
		boolean[] visited = new boolean[256];
		for (char c : s.toCharArray())
			freq[c]++;
		Stack<Character> stack = new Stack<>();

		for (char c : s.toCharArray()) {
			freq[c]--;
			if (visited[c])
				continue;
			while (!stack.isEmpty() && stack.peek() > c && freq[stack.peek()] > 0)
				visited[stack.pop()] = false;
			stack.push(c);
			visited[c] = true;
		}

		StringBuffer sb = new StringBuffer();
		for (char c : stack)
			sb.append(c);
		return sb.reverse().toString();
	}
}
