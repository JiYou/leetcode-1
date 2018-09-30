package com.leetcode.String;

/**
 * Created by lhcxx on 18/9/27.
 */
public class StringToInteger_Leetcode8 {
	public int atoi(String str) {
		if (str == null || str.length() == 0)
			return 0;
		str = str.trim();
		char first = str.charAt(0);
		int sign = 1;
		int start = 0;
		long res = 0;
		if (first == '+'){
			sign = 1;
			start++;
		} else if (first == '-') {
			sign = -1;
			start++;
		}
		for (int i = start; i < str.length(); i++) {
			if (!Character.isDigit(str.charAt(i)))
				return (int)res * sign;
			res = res * 10 + str.charAt(i) - '0';
			if (sign == 1 && res > Integer.MAX_VALUE)
				return Integer.MAX_VALUE;
			if (sign == -1 && res > Integer.MAX_VALUE)
				return Integer.MIN_VALUE;
		}
		return (int) res * sign;
	}
}
