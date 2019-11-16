package leetcode;

import java.util.*;

public class _347_TopKFrequentElements {
	public List<Integer> topKFrequentE(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int num : nums)
			map.put(num, map.getOrDefault(num, 0) + 1);
		PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>( (a,b) ->(b.getValue() - a.getValue()));
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			queue.offer(entry);
		}
		List<Integer> res = new ArrayList<>();
		while (res.size() < k) {
			res.add(queue.poll().getKey());
		}
		return res;
	}

	public List<Integer> topKFrequentE2(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int num : nums)
			map.put(num, map.getOrDefault(num, 0) + 1);
		List<Integer>[] bucket = new List[nums.length + 1];
		for (int key : map.keySet()) {
			int freq = map.get(key);
			if (bucket[freq] == null)
				bucket[freq] = new ArrayList<>();
			bucket[freq].add(key);
		}

		List<Integer> res = new ArrayList<>();
		for (int i = bucket.length - 1; i>=0 && res.size() < k; i++) {
			if (bucket[i] != null)
				res.addAll(bucket[i]);
		}
		return res;
	}
}
