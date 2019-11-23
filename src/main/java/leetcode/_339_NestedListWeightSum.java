package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _339_NestedListWeightSum {


	// DFS
	public int depthSum(List<NestedInteger> nestedList) {
		if (nestedList == null)
			return 0;
		return helper(nestedList, 1);
	}

	private int helper(List<NestedInteger> nestedList, int depth) {
		int res = 0;
		for (NestedInteger nes : nestedList) {
			if (nes.isInteger())
				res += nes.getInteger() * depth;
			else {
				res += helper(nes.getList(), depth + 1);
			}
		}
		return res;
	}


	//BFS
	public int depthSum2(List<NestedInteger> nestedList) {
		if (nestedList == null)
			return 0;

		int depth = 1;
		int res = 0;

		Queue<NestedInteger> queue = new LinkedList<>(nestedList);

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				NestedInteger nes = queue.poll();
				if (nes.isInteger())
					res += nes.getInteger() * depth;
				else
					queue.addAll(nes.getList());
			}
			depth++;
		}
		return res;
	}


}
