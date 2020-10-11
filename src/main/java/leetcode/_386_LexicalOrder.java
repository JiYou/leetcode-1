package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

	public List<Integer> lexicalOrder2(int n) {
		List<Integer> res = new ArrayList<Integer>();
		Stack<Integer> tree = new Stack<Integer>();

		if (n < 10)
			for (int i = n; i > 0; i--)
				tree.push(i);
		else
			for (int i = 9; i > 0; i--)
				tree.push(i);

		int t, m;
		while (!tree.empty()) {
			t = tree.peek();
			tree.pop();
			res.add(t);
			if (t * 10 > n) continue;
			else {
				m = n - t * 10;
				if (m > 9)
					m = 9;
			}
			for (int i = m; i >= 0; i--)
				tree.push(t * 10 + i);
		}
		return res;
	}
}
