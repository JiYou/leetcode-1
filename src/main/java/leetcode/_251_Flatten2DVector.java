package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _251_Flatten2DVector {

	Queue<Integer> queue;

	public _251_Flatten2DVector(int[][] v) {
		queue = new LinkedList<>();
		init(v);
	}

	public int next() {
		if(hasNext())
			return queue.poll();
		return -1;
	}

	public boolean hasNext() {
		if(queue.isEmpty())
			return false;
		return true;
	}

	private void init(int[][] v) {
		if(v == null || v.length == 0)
			return;
		for(int[] a: v) {
			for (int i : a)
				queue.offer(i);
		}
	}
}
