package com.leetcode.math;

public class Pow_50 {
	public double pow(double x, int n) {
		if (n > 0)
			return pow_1(x, n);
		else
			return 1.0 / pow_1(x, n);
	}

	private double pow_1(double x, int n) {
		if (n == 0)
			return 1;
		double y = pow(x, n / 2);
		if (n % 2 == 0)
			return y * y;
		else
			return y * y * x;
	}

	public double pow1(double x, int n) {
		if (n == 0)
			return 1;
		int res = 1;
		int abs = Math.abs(n);
		while (abs > 0) {
			if (abs % 2 != 0)
				res *= x;
			x *= x;
			abs /= 2;
		}
		if (n < 0)
			return 1.0 / res;
		return res;
	}
}
