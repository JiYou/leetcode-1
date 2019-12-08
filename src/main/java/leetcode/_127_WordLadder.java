package leetcode;

import java.util.*;

public class _127_WordLadder {


	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		HashSet<String> set = new HashSet<>(wordList);
		if (set.contains(beginWord))
			set.remove(beginWord);

		int level = 1, cur = 1, next = 0;
		Queue<String> queue = new LinkedList<>();
		queue.offer(beginWord);
		while (!queue.isEmpty()) {
			String word = queue.poll();
			cur--;

			for (int i = 0; i < word.length(); i++) {
				char[] arrs = word.toCharArray();
				for (char j = 'a'; j < 'z'; j++) {
					arrs[i] = j;
					String tmp = new String(arrs);
					if (wordList.contains(tmp)) {
						if (tmp.equals(endWord))
							return level + 1;
						next++;
						queue.offer(tmp);
						set.remove(tmp);
					}
				}
			}
			if (cur == 0) {
				cur = next;
				next = 0;
				level++;
			}
		}
		return 0;
	}

	public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
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
