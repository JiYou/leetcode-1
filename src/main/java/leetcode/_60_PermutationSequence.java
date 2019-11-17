package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _60_PermutationSequence {
	public static String getPermutation(int n, int k) {
		List<Integer> res = new ArrayList<>();
		int[] fact = new int[n];
		fact[0] = 1;

		for (int i = 1; i < n; i++)
			fact[i] = i * fact[i - 1];

		for (int i = 1; i <= n; i++) {
			res.add(i);
		}
		k = k - 1;

		StringBuffer sb = new StringBuffer();

		for (int i = n; i > 0; i--) {
			int index = k / fact[i - 1];
			k = k % fact[i - 1];
			sb.append(res.get(index));
			res.remove(index);
		}

		return sb.toString();
	}
}
