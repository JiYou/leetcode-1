package com.leetcode.String;

/**
 * Created by lhcxx on 18/10/20.
 */
public class ExcelSheetColumnTitle_Leetcode168 {
	public String convertToTitle(int n) {
		StringBuffer sb = new StringBuffer();
		while (n > 0) {
			n--;
			sb.append((char)('A' + n % 26));
			n /= 26;
		}
		return sb.reverse().toString();
	}
}
