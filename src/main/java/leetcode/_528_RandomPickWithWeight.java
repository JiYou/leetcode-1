package leetcode;

import java.util.Random;

public class _528_RandomPickWithWeight {
	private Random random;
	private int[] sum;

	public _528_RandomPickWithWeight(int[] w) {
		random = new Random();
		for (int i = 1; i < w.length; i++)
			w[i] += w[i - 1];
		this.sum = w;
	}

	public int pickIndex() {
		int index = random.nextInt(sum[sum.length - 1]) + 1;
		int left = 0;
		int right = sum.length - 1;
		while (left < right) {
			int mid = (right - left) / 2 + left;
			if (sum[mid] == index)
				return mid;
			else if (sum[mid] > index)
				right = mid + 1;
			else
				left = mid;
		}
		return left;
	}
}
