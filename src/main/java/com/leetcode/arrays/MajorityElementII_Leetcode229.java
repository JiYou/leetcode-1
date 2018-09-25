package com.leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lhcxx on 18/9/25.
 */
public class MajorityElementII_Leetcode229 {
	public List<Integer> majorityElement(int[] nums) {
		if (nums == null || nums.length == 0)
			return new ArrayList<>();
		List<Integer> res = new ArrayList<>();
		int number1 = 0, number2 = 0;
		int count1 = 0, count2 = 0;
		for (int num : nums) {
			if (count1 == 0) {
				number1 = num;
				count1 = 1;
			} else if (count2 == 0) {
				number2 = num;
				count2 = 1;
			} else if (num == number1)
				count1++;
			else if (num == number2)
				count2++;
			else {
				count1--;
				count2--;
			}
		}

		count1 = 0;
		count2 = 0;

		for (int num : nums) {
			if (num == number1)
				count1++;
			else if (num == number2)
				count2++;
		}

		if (count1 > nums.length / 3)
			res.add(number1);
		if (count2 > nums.length / 3)
			res.add(number2);
		return res;
	}
}
