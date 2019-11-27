package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _254_FactorCombinations {
	public List<List<Integer>> getFactors(int n) {
		List<List<Integer>> res = new ArrayList<>();
		helper(res, new ArrayList<>(), n, 2);
		return res;
	}

	private void helper(List<List<Integer>>res, List<Integer> list, int n, int start) {
		if (n == 1 && list.size() > 1) {
			res.add(new ArrayList<>(list));
			return;
		}

		for (int i = start; i <= n; i++) {
			if (n % start == 0) {
				list.add(start);
				helper(res, list, n / i, i);
				list.remove(list.size() - 1);
			}
		}
	}
}
