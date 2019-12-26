package leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;

public class _621_TaskScheduler {
	public int taskScheduler(char[] tasks, int n) {
		int[] count = new int[26];
		for (char c : tasks)
			count[c-'A']++;
		Arrays.sort(count);
		int i = 25;
		while (i >= 0 && count[i] == count[25])
			i--;
		return Math.max(tasks.length, (count[25] - 1) * (n + 1) + 25 - i);
	}

	public int taskScheduler2(char[] tasks, int n) {
		int[] map = new int[26];
		for (char c : tasks)
			map[c - 'A']++;
		Arrays.sort(map);

		int max = map[25] - 1, idleSlots = max * n;
		for (int i = 24; map[i] > 0 && i >= 0; i--) {
			idleSlots -= Math.min(max, map[i]);
		}

		return idleSlots > 0 ? tasks.length + idleSlots : tasks.length;
	}
}
