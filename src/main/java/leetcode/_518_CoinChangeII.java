package leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;

public class _518_CoinChangeII {

	private int res = 0;

	public int change(int amount, int[] coins) {
		int len = coins.length;
		Arrays.sort(coins);
		helper(amount, coins, 0, len);
		return res;
	}

	private void helper(int remain, int[] coins, int start, int len) {
		if (remain == 0) {
			res++;
			return;
		}

		for (int i = start; i < len; i++) {
			if (remain - coins[i] < 0)
				break;
			helper(remain - coins[i], coins, i, len);
		}
	}
}
