package com.leetcode.DivideAndConuer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lhcxx on 18/9/25.
 */
public class DifferentWaystoAddParentheses_Leetcode241 {
	public List<Integer> diffWaysToCompute(String input) {
		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (c == '-' || c == '*' || c == '+') {
				String a = input.substring(0, i);
				String b = input.substring(i + 1);
				List<Integer> al = diffWaysToCompute(a);
				List<Integer> bl = diffWaysToCompute(b);
				for (int x : al) {
					for (int y : bl) {
						if (c == '-')
							res.add(x - y);
						else if (c == '+')
							res.add(x + y);
						else
							res.add(x * y);
					}
				}
			}
		}
		if (res.size() == 0)
			res.add(Integer.valueOf(input));
		return res;
	}
}
