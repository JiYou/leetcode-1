package leetcode;

public class _397_IntegerReplacement {
	public int integerReplacement1(int n) {
		int N = n;
		int res = 0;
		while (N != 1) {
			if (N % 2 == 0)
				N >>= 1;
			else {
				if (N == 3) {
					N += 2;
					break;
				}
				N = (N & 2) == 2? N + 1 : N - 1;
			}
			res++;
		}
		return res;
	}

	public int integerReplacement2(int n) {
		if (n == Integer.MAX_VALUE)
			return 32;
		int res = 0;
		while (n != 1) {
			if (n % 2 == 0)
				n /= 2;
			else {
				if ((n + 1) % 4 == 0 && n != 3)
					n++;
				else
					n--;
			}
			res++;
		}
		return res;
	}


}
