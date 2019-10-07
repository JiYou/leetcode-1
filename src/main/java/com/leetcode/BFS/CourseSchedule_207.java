package com.leetcode.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule_207 {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		int[] indegree = new int[numCourses];
		for (int[] nums : prerequisites) {
			indegree[nums[0]]++;
		}
		int res = numCourses;

		Queue<Integer> queue = new LinkedList<>();
		for (int i : indegree)
			if (i == 0)
				queue.offer(i);

		while (!queue.isEmpty()) {
			int pre = queue.poll();
			res--;
			for (int[] pair : prerequisites) {
				if (pair[1] == pre)
					indegree[pair[0]]--;
				if (indegree[pair[0]] == 0)
					queue.offer(pair[0]);
			}
		}
		return res == 0;
	}
}
