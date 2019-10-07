package com.leetcode.String;

public class MultiplyStrings_43 {
	public String multiply(String num1, String num2) {
		if (num1 == null || num2 == null) return "0";
		int[] nums = new int[num1.length() + num2.length()];
		for (int i = 0; i < num1.length(); i++)
			for (int j = 0; j < num2.length(); j++) {
				int product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
				int p1 = i + j, p2 = i + j + 1;
				int sum = product + nums[p2];
				nums[p2] = sum % 10;
				nums[p1] += sum / 10;
			}
		StringBuffer sb = new StringBuffer();
		for (int i : nums) {
			if (!(i == 0 && sb.length() == 0)) {
				sb.append(nums[i]);
			}
		}
		return sb.length() == 0 ? "0" : sb.toString();
	}

}
