package leetcode;

public class _29_DivideTwoIntegers {
	public int divide(int dividend, int divisor) {
		int sign = 1;
		if (dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0)
			sign = -1;
		if (dividend < divisor || dividend == 0)
			return 0;
		long ldividend = Math.abs((long)dividend);
		long ldivisor = Math.abs((long)divisor);

		long lres = divide(ldividend, ldivisor);
		int res = 0;
		if (lres > Integer.MAX_VALUE)
			res = (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
		else
			res = (int) (sign * lres);
		return res;
	}

	private long divide(long dividend, long divisor) {
		if (dividend < divisor)
			return 0;
		long sum = divisor;
		long multiple = 1;
		while (sum + sum < dividend) {
			sum += sum;
			multiple += multiple;
		}
		return multiple + divide(dividend - sum, divisor);
	}
}
