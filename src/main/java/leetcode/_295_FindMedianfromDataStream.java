package leetcode;

import java.util.PriorityQueue;

public class _295_FindMedianfromDataStream {
	private PriorityQueue<Integer> small;
	private PriorityQueue<Integer> large;

	public _295_FindMedianfromDataStream() {
		small = new PriorityQueue<>();
		large = new PriorityQueue<>();
	}

	public void addNum(int num) {
		large.add(num);
		small.add(-large.poll());
		if (large.size() < small.size())
			large.add(-small.poll());
	}

	public double findMedian() {
		return large.size() > small.size() ? large.peek() : (large.peek() - small.peek()) / 2;
	}

}
