package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _386_LexicalOrder {
	public List<Integer> lexicalOrder(int n) {
		List<Integer> res = new ArrayList<>();
		lexicalOrder(res, null, n);
		return res;
	}

	public void lexicalOrder(List<Integer> res, Integer cur, int max) {
		if (cur != null && cur > max)
			return;
		if (cur != null)
			res.add(cur);

		for (int i = 0; i <= 9; i++) {
			if (cur == null) {
				if (i == 0)
					continue;
				else
					cur = 0;
			}
			lexicalOrder(res, cur * 10 + i, max);
		}
	}
}
