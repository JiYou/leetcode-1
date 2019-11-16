package leetcode;

import javafx.util.Pair;

import java.util.*;

public class _692_TopKFrequentWords {
	public List<String> topKFrequent(String[] words, int k) {
		List<String> res = new ArrayList<>();
		HashMap<String, Integer> map = new HashMap<>();
		for (String word : words)
			map.put(word, map.getOrDefault(word, 0) + 1);
		PriorityQueue<Map.Entry<String,Integer>> queue = new PriorityQueue<>( (a,b) -> {
			if (a.getValue() < b.getValue())
				return 1;
			else if (a.getValue() > b.getValue())
				return -1;
			else return a.getKey().compareTo(b.getKey());
		});
		for (Map.Entry<String, Integer> enrty : map.entrySet()) {
			queue.offer(enrty);
		}

		for (int i = 0; i < k; i++)
			res.add(queue.poll().getKey());
		return res;
	}

	public List<String> topKFrequent2(String[] words, int k) {
		List<String> res = new ArrayList<>();
		HashMap<String, Integer> map = new HashMap<>();
		for (String word : words)
			map.put(word, map.getOrDefault(word, 0) + 1);
		List<String>[] bucket = new List[words.length + 1];
		for (String key : map.keySet()) {
			int freq = map.get(key);
			if (bucket[freq] == null)
				bucket[freq] = new ArrayList<>();
			bucket[freq].add(key);
		}

		for (int i = words.length - 1; i >= 0 && res.size() < k; i--) {
			if (bucket[i] != null) {
				Collections.sort(bucket[i]);
				res.addAll(bucket[i]);
			}
		}
		return res;
	}

}
