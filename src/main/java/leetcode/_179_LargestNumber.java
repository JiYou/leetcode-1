package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class _179_LargestNumber {
	public String largestNumber(int[] nums) {
		if (nums == null || nums.length == 0)
			return "";
		String[] strs = new String[nums.length];
		for (int i = 0; i < nums.length; i++)
			strs[i] = String.valueOf(nums[i]);
		Arrays.sort(strs, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				String a = o1 + o2;
				String b = o2 + o1;
				return b.compareTo(a);
			}
		});

		if (strs[0].charAt(0)  == '0')
			return "0";
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < strs.length; i++)
			sb.append(strs[i]);
		return sb.toString();
	}
}
