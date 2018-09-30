package com.leetcode.arrays;


import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by lhcxx on 18/9/26.
 */
public class LargestNumber_Leetcode179 {
	public String largestNumber(int[] nums){
		if (nums == null || nums.length == 0)
			return "";
		String[] res = new String[nums.length];
		for (int i = 0; i < nums.length; i++)
			res[i] = String.valueOf(nums[i]);
		Arrays.sort(res, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				String s1 = o1 + o2;
				String s2 = o2 + o1;
				return s2.compareTo(s1);
			}
		});

		if (res[0].charAt(0) == '0')
			return "0";
		StringBuffer sb = new StringBuffer();
		for (String s: res)
			sb.append(s);
		return sb.toString();
	}
}