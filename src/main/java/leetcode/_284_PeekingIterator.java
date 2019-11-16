package leetcode;

import java.util.Iterator;

public class _284_PeekingIterator {
	private Iterator<Integer> iter;
	private Integer next = null;

	public _284_PeekingIterator(Iterator<Integer> it) {
		iter = it;
		if (it.hasNext()) {
			next = it.next();
		}
	}

	public Integer peek() {
		return next;
	}

	public Integer next() {
		Integer res = next;
		next = iter.hasNext() ? iter.next() : null;
		return res;
	}

	public boolean hasNext() {
		return next != null;
	}
}
