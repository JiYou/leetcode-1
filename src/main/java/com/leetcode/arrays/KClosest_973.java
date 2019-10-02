package com.leetcode.arrays;

import java.util.PriorityQueue;

public class KClosest_973 {
	public int[][] kCloset(int[][] points, int k) {
		PriorityQueue<int[]> queue = new PriorityQueue<>(k + 1, (a, b) -> (b[0]*b[0] + b[1]*b[1] - a[0]*a[0] - a[1] * a[1]));
		for (int[] point : points) {
			queue.offer(point);
			if (queue.size() > k)
				queue.poll();
		}
		int[][]res = new int[k][2];
		int i = 0;
		while (queue.size() > 0)
			res[i++] = queue.poll();
		return res;
	}
}
