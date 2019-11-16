package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class _373_FindKPairsWithSmallestSums {
	public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		List<int[]> res = new ArrayList<>();
		if (nums1.length == 0 || nums2.length == 0)
			return res;
		PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> (a[0]+ a[1] - b[0] - b[1]));

		for (int i = 0; i < nums1.length && i < k; i++) {
			queue.offer(new int[] {nums1[i], nums2[0], 0});
		}

		while (!queue.isEmpty() && k-->0) {
			int[] cur = queue.poll();
			res.add(new int[] {cur[0], cur[1]});
			if (cur[2] == nums2.length - 1) continue;
			queue.offer(new int[] {cur[0], nums2[cur[2] + 1], cur[2] + 1});
		}
		return res;
	}
}
