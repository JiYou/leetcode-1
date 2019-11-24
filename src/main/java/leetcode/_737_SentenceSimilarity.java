package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class _737_SentenceSimilarity {
	public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
		if (words1.length != words2.length)
			return false;
		HashMap<String, HashSet<String>> map = new HashMap<>();

		for (String[] pair : pairs) {
			if (!map.containsKey(pair[0]))
				map.put(pair[0], new HashSet<>());
			if (!map.containsKey(pair[1]))
				map.put(pair[1], new HashSet<>());

			map.get(pair[0]).add(pair[1]);
			map.get(pair[1]).add(pair[0]);
		}

		HashSet<String> visited = new HashSet<>();
		Queue<String> queue = new LinkedList<>();

		for (int i = 0; i < words1.length; i++) {
			if (words1[i].equals(words2[i]))
				continue;
			boolean succ = false;
			queue.offer(words1[i]);

			while (!queue.isEmpty()) {
				String cur = queue.poll();
				if (map.containsKey(cur)) {
					succ = true;
					break;
				}
				visited.add(cur);
				for (String s : map.get(cur)) {
					if (!visited.contains(s))
						queue.offer(s);
				}

			}
			if (!succ)
				return false;
		}
		return true;
	}

	HashMap<String,String> roots;

	public boolean areSentencesSimilar2(String[] words1, String[] words2, String[][] pairs) {
		if (words1.length != words2.length)
			return false;
		roots = new HashMap<>();
		for (int i = 0; i < words1.length; i++)
			roots.put(words1[i], words1[i]);
		for (String[] pair : pairs) {
			String x = find(pair[0]);
			String y = find(pair[1]);
			if (x != y)
				roots.put(x,y);
		}

		for (int i = 0; i < words1.length; i++)
			if (find(words1[i]) != find(words2[i]))
				return false;
		return true;
	}

	private String find(String word) {
		return roots.get(word) == word ? word : find(roots.get(word));
	}


}
