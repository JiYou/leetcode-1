package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _216_CombinationSumIII {
	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> res = new ArrayList<>();
		helper(res, new ArrayList<>(), n, k, 1);
		return res;
	}

	private void helper(List<List<Integer>> res, List<Integer> list, int n, int k, int start) {
		if (k == 0 && n == 0) {
			res.add(new ArrayList<>(list));
			return;
		}

		for (int i = start; i <= 9; i++) {
			list.add(i);
			helper(res, list, n - i, k - 1, i + 1);
			list.remove(list.size() - 1);
		}
	}
}
