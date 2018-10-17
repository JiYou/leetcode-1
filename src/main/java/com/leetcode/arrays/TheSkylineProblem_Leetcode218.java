package com.leetcode.arrays;

import java.util.*;

/**
 * Created by lhcxx on 18/10/12.
 */
public class TheSkylineProblem_Leetcode218 {
	public List<int[]> getSkyline(int[][] buildings) {
		List<int[]> res = new ArrayList<>();
		List<int[]> height = new ArrayList<>();

		Collections.sort(height, (a, b) -> (a[0] != b[0]) ? a[0] - b[0] : a[1] - b[1]);
		Queue<Integer> pq = new PriorityQueue<Integer>((a, b) -> (b - a));

		int prev = 0;
		int cur = 0;
		pq.offer(0);
		for (int[] h : height) {
			if (h[1] < 0)
				pq.offer(-h[1]);
			else
				pq.remove(h[1]);

			cur = pq.peek();
			if (cur != prev) {
				res.add(new int[]{h[0], cur});
				prev = cur;
			}
		}
		return res;
	}
}
