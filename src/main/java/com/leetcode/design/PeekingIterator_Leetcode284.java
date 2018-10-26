package com.leetcode.design;

import java.util.Iterator;

/**
 * Created by lhcxx on 18/10/24.
 */
public class PeekingIterator_Leetcode284<T> implements Iterator<T>{
	private Iterator<T> iter;
	private T next = null;

	public PeekingIterator_Leetcode284(Iterator<T> it) {
		iter = it;
		if (it.hasNext())
			next = it.next();
	}

	public T peek() {
		return next;
	}

	@Override
	public boolean hasNext() {
		return next != null;
	}

	@Override
	public T next() {
		T res = next;
		next = iter.hasNext() ? iter.next() : null;
		return res;
	}
}
