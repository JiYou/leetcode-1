package com.leetcode.design;

import java.util.PriorityQueue;

public class FindMedianfromDataStream_295 {
	private PriorityQueue<Long> large;
	private PriorityQueue<Long> small;

	FindMedianfromDataStream_295() {
		large = new PriorityQueue<>();
		small = new PriorityQueue<>();
	}

	public void addNum(int num) {
		large.add((long) num);
		small.add(-large.poll());
		if (large.size() < small.size()) {
			large.add(-small.poll());
		}
	}

	public double findMedian() {
		return large.size() > small.size() ? large.peek() : (large.peek() - small.peek()) / 2;
	}

}
