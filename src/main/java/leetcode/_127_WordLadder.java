package leetcode;

import java.util.*;

public class _127_WordLadder {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		HashSet<String> set = new HashSet<>(wordList);
		if (set.contains(beginWord)) {
			set.remove(beginWord);
		}
		Queue<String> queue = new LinkedList<>();
		HashMap<String, Integer> map = new HashMap<>();
		map.put(beginWord, 1);
		queue.offer(beginWord);
		while (!queue.isEmpty()) {
			String word = queue.poll();
			int curLevel = map.get(word);
			for (int i = 0; i < word.length(); i++) {
				char[] wordUnit = word.toCharArray();
				for (char j = 'a'; j <= 'z'; j++) {
					wordUnit[i] = j;
					String temp = new String(wordUnit);
					if (set.contains(temp)) {
						if (temp.equals(endWord)) {
							return curLevel + 1;
						}
						map.put(temp, curLevel + 1);
						queue.offer(temp);
						set.remove(temp);
					}
				}
			}
		}
		return 0;
	}
}
