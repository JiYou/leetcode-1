package com.leetcode.math;

/**
 * Created by lhcxx on 18/10/4.
 */
public class ValidPerfectSquare_Leetcode367 {
	public boolean isPerfectSquare(int num) {
		if (num < 0) return false;
		if (num == 1) return true;
		for (int i = 1; i <= num / i; i++) {
			if (i * i == num)
				return true;
		}
		return false;
	}

	public boolean isPerfectSquare2(int num) {
		int low = 1;
		int high = num;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (mid * mid == num)
				return true;
			else if(mid * mid > num)
				high = mid - 1;
			else
				low = mid + 1;
		}
		return false;
	}

}
