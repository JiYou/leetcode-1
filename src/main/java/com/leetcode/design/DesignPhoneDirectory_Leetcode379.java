package com.leetcode.design;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by lhcxx on 18/10/26.
 */
public class DesignPhoneDirectory_Leetcode379 {
	private HashSet<Integer> used = new HashSet<>();
	private Queue<Integer> queue = new LinkedList<>();
	int max;

	public DesignPhoneDirectory_Leetcode379(int n) {
		max = n;
		for (int i = 0; i < n; i++)
			queue.offer(i);
	}

	public int get() {
		Integer res = queue.poll();
		if (res == null)
			return -1;
		used.add(res);
		return res;
	}

	public boolean check(int n) {
		if (n >= max || n < 0)
			return false;
		return !used.contains(n);
	}

	public void release(int n) {
		if (used.remove(n))
			queue.offer(n);
	}
}
