package com.leetcode.DP;

/**
 * Created by lhcxx on 18/10/6.
 */
public class ClimbingStairs_Leetcode70 {
	public int climbingStairs(int n) {
		if (n <= 1) return n;
		int oneStep = 1, twoStep = 1;
		int res = 0;
		for (int i = 1; i <=n; i++) {
			res = oneStep + twoStep;
			twoStep = oneStep;
			oneStep = res;
		}
		return res;
	}
}
