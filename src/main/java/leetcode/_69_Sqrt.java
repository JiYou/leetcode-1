package leetcode;

public class _69_Sqrt {
	public int mySqrt(int x) {
		if (x <= 0) return 0;
		int low = 1, high = x;
		while (low <= high) {
			int mid = (high - low) / 2 + low;
			if (mid * mid == x)
				return mid;
			else if (mid * mid > x)
				high = mid - 1;
			else
				low = mid + 1;
		}
		if (high * high < x)
			return high;
		else return low;
	}
}
