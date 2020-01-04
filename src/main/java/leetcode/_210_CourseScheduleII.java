package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class _210_CourseScheduleII {
	public int[] findres(int numCourses, int[][] prerequisites) {
		int[] degress = new int[numCourses];
		for (int[] pair : prerequisites) {
			degress[pair[0]]++;
		}
		int[] res = new int[numCourses];
		int k = 0;
		Queue<Integer> queue = new LinkedList<>();

		for (int i = 0; i < numCourses; i++)
			if (degress[i] == 0) {
				queue.offer(i);
				res[k++] = i;
			}

		while (!queue.isEmpty()) {
			int cur = queue.poll();
			for (int[] pair : prerequisites) {
				if (pair[1] == cur) {
					degress[pair[0]]--;
					if (degress[pair[0]] == 0) {
						queue.offer(degress[pair[0]]);
						res[k++] = pair[0];
					}
				}
			}
		}
		return (k == numCourses) ? res : new int[0];
	}
}
