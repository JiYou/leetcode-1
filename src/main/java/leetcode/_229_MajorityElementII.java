package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _229_MajorityElementII {
	public static List<Integer> majorityElement(int[] nums) {
		List<Integer> res = new ArrayList<>();
		if (nums == null || nums.length == 0)
			return res;
		int number1 = 0, number2 = 0, count1 = 0, count2 = 0;
		for (int n : nums) {
			if (n == number1)
				count1++;
			else if (n == number2)
				count2++;
			else if (count1 == 0) {
				number1 = n;
				count1 = 1;
			} else if (count2 == 0) {
				number2 = n;
				count2 = 1;
			} else {
				count1--;
				count2--;
			}
		}
		count1 = 0;
		count2 = 0;
		for (int n : nums)
			if (n == number1)
				count1++;
		for (int n : nums)
			if (n == number2)
				count2++;
		if (count1 > nums.length / 3)
			res.add(number1);
		if (count2 > nums.length / 3 && number2 != number1)
			res.add(number2);

		return res;
	}
}
