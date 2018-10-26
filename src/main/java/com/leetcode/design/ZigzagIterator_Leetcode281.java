package com.leetcode.design;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by lhcxx on 18/10/24.
 */
public class ZigzagIterator_Leetcode281<T> implements Iterator<T> {
	List<Iterator<T>> itList;
	int turns;

	@Override
	public boolean hasNext() {
		return itList.size() > 0;
	}

	@Override
	public T next() {
		if (!hasNext())
			return null;
		T res;
	  int pos = turns % itList.size();
		Iterator<T> it = itList.get(pos);
		res = it.next();
		if (!it.hasNext()) {
			itList.remove(pos);
			turns = pos - 1;
		}
		turns++;
		return res;
	}

	public ZigzagIterator_Leetcode281(List<Iterator<T>> list) {
		itList = new LinkedList<>();
		for (Iterator<T> it : list) {
			if (it.hasNext())
				itList.add(it);
		}
		turns = 0;
	}
}
