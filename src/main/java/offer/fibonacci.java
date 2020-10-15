package offer;

public class fibonacci {
	public long fibonacci(long n) {
		if (n <= 2) return 1;
		long first = 1;
		long second = 1;
		long third = 0;
		for(int i = 3; i <= n; i++) {
			third = first + second;
			first = second;
			second = third;
		}
		return third;
	}
}
