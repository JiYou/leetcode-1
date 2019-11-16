package leetcode;

public class _50_Pow {
	public static double myPow1(double x, int n) {
		if (n > 0)
			return pow(x, n);
		else
			return 1.0 / pow(x, n);
	}

	public static double pow (double x, int n) {
		if (n == 0)
			return 1;
		double y = pow(x, n / 2);
		if (n % 2 == 0)
			return y * y;
		else
			return y * y * x;
	}

	public static double myPow2(double x, int n) {
		if (n == 0)
			return 1;
		int abs = Math.abs(n);
		double res = 1;
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
