package com.leetcode.DFS;

import java.util.*;

public class WordLadder_127 {
	public int ladderLength(String begin, String end, List<String> words) {
		HashSet<String> set = new HashSet<>(words);
		if (set.contains(begin))
			set.remove(begin);
		Queue<String> queue = new LinkedList<>();
		HashMap<String, Integer> map = new HashMap<>();
		queue.offer(begin);
		map.put(begin, 1);

		while (!queue.isEmpty()) {
			String word = queue.poll();
			int cur = map.get(word);
			for (int i = 0; i < word.length(); i++) {
				char[] list = word.toCharArray();
				for (char j = 'a'; j <= 'z'; j++) {
					list[i] = j;
					String tmp = new String(list);
					if (set.contains(tmp)) {
						if (tmp.equals(end))
							return cur + 1;
						queue.offer(tmp);
						map.put(tmp, cur + 1);
						set.remove(tmp);
					}
				}
			}
		}
		return 0;
	}
}
