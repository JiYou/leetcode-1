package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
}
