package com.leetcode.math;

/**
 * Created by lhcxx on 18/10/5.
 */
public class AddBinary_Leetcode67 {
	public String addBinary(String a, String b) {
		StringBuffer sb = new StringBuffer();
		int i = a.length() - 1;
		int j = b.length() - 1;
		int reminder = 0;
		int sum = 0;
		while (i >= 0 || j >= 0) {
			sum = reminder;
			if (i >= 0) sum += a.charAt(i) - '0';
			if (j >= 0) sum += b.charAt(j) - '0';
			sb.append(sum % 2);
			reminder = sum / 2;
		}
		if (reminder != 0)
			sb.append(reminder);
		return sb.reverse().toString();
	}

}
