package com.leetcode.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by lhcxx on 18/10/26.
 */
public class ImplementStackusingQueues_Leetcode225 {
	Queue<Integer> queue;

	public ImplementStackusingQueues_Leetcode225() {
		queue = new LinkedList<>();
	}

	public void push(int a) {
		queue.add(a);
		for (int i = 0; i < queue.size(); i++)
			queue.add(queue.poll());
	}

	public Integer pop() {
		return queue.poll();
	}

	public Integer peek() {
		return queue.peek();
	}

	public boolean empty() {
		return queue.isEmpty();
	}
}
