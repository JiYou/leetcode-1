package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class _218_TheSkylineProblem {
	public List<int[]> getSkyline(int[][] buildings) {
		List<int[]> res = new ArrayList<>();
		List<int[]> heights = new ArrayList<>();
		for (int[] b : buildings) {
			heights.add(new int[] {b[0], -b[2]});
			heights.add(new int[] {b[1], b[2]});
		}
		Collections.sort(heights, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]));
		PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> (b - a));
		queue.offer(0);
		int prev = 0;

		for (int[] h : heights) {
			if (h[1] < 0) {
				queue.offer(-h[1]);
			} else {
				queue.remove(h[1]);
			}
			int cur = queue.peek();
			if (cur != prev) {
				res.add(new int[] {h[0], cur});
				prev = cur;
			}
		}
		return res;
	}
}
