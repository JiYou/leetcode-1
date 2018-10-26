package com.leetcode.design;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by lhcxx on 18/10/25.
 */
public class MovingAveragefromDataStream_Leetcode346 {
	private Queue<Integer> queue;
	private int size;
	private double sum = 0;

	public  MovingAveragefromDataStream_Leetcode346(int size) {
		queue = new LinkedList<>();
		this.size = size;
	}

	public double next(int val) {
		if (size == queue.size()) {
			sum -= queue.remove();
		}
		sum += val;
		queue.offer(val);
		return sum / queue.size();
	}
}
