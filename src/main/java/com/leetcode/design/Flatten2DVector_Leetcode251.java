package com.leetcode.design;

import java.util.List;

/**
 * Created by lhcxx on 18/10/25.
 */
public class Flatten2DVector_Leetcode251 {
	private int indexElement;
	private int indexList;
	private List<List<Integer>> list;

	public Flatten2DVector_Leetcode251(List<List<Integer>> vec2d) {
		indexElement = 0;
		indexList = 0;
		list = vec2d;
	}

	public Integer next() {
		return list.get(indexList).get(indexElement++);
	}

	public boolean hasNext() {
		while (indexList < list.size()) {
			if (indexElement < list.get(indexList).size())
				return true;
			else {
				indexElement = 0;
				indexList++;
			}
		}
		return false;
	}
}
