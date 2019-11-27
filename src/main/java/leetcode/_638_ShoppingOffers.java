package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _638_ShoppingOffers {
	public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
		return shopping(price, special, needs);
	}

	private int shopping(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
		int j = 0, res = sum(needs, price);
		for (List<Integer> s : special) {
			List<Integer> clone = new ArrayList<>(needs);
			for ( ; j < needs.size(); j++) {
				int diff = clone.get(j) - s.get(j);
				if (diff < 0)
					continue;
				clone.set(j, diff);
			}
			if (j == needs.size())
				res = Math.min(res, s.get(j) + shopping(price, special, clone));
		}
		return res;
	}

	private int sum(List<Integer> needs, List<Integer> prices) {
		int sum = 0;
		for (int i = 0; i < needs.size(); i++)
			sum += needs.get(i) * prices.get(i);
		return sum;
	}
}
