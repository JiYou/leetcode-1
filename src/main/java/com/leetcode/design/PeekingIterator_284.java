package com.leetcode.design;

import java.util.Iterator;

public class PeekingIterator_284 {

	private Iterator<Integer> iter;
	private Integer next = null;

	public PeekingIterator_284(Iterator<Integer> iterator) {
		iter = iterator;
		if (iter.hasNext())
			next = iter.next();
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
