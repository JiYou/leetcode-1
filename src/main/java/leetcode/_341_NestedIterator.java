package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _341_NestedIterator {
	private Queue<Integer> list;

	public _341_NestedIterator(List<NestedInteger> list) {
		list = new LinkedList<>();
		dfs(list);
	}

	public Integer next() {
		return list.poll();
	}

	public boolean hasNext() {
		return list.size() > 0;
	}

	private void dfs(List<NestedInteger> nestedList) {
		if (nestedList == null)
			return;
		for (NestedInteger nestedInteger : nestedList) {
			if (nestedInteger.isInteger())
				list.offer(nestedInteger.getInteger());
			else
				dfs(nestedInteger.getList());
		}
	}
}
