package com.leetcode.String;

/**
 * Created by lhcxx on 18/10/20.
 */
public class ExcelSheetColumnNumber_Leetcode171 {
	public int titleToNumber(String s) {
		int res = 0;
		for (Character c : s.toCharArray()) {
			res = res * 26 + (c - 'A' + 1);
		}
		return res;
	}
}
