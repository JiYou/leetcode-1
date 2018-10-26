package com.leetcode.design;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by lhcxx on 18/10/25.
 */
public class DesignHitCounter_Leetcode362 {
	Queue<Integer> queue;

	public DesignHitCounter_Leetcode362() {
		queue = new LinkedList<>();
	}

	public void hit(int timestamp) {
		queue.offer(timestamp);
	}

	public int getHit(int timestamp) {
		while (!queue.isEmpty() && (timestamp - queue.peek() > 300))
			queue.poll();
		return queue.size();
	}
}
