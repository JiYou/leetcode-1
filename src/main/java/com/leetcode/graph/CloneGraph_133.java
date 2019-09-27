package com.leetcode.graph;

import common.UndirectedGraphNode;

import java.util.*;

public class CloneGraph_133 {

	private HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		return helper(node);
	}

	private UndirectedGraphNode helper(UndirectedGraphNode node) {
		if (node == null)
			return null;
		if (map.containsKey(node))
			return map.get(node);
		UndirectedGraphNode dup = new UndirectedGraphNode(node.label);
		for (UndirectedGraphNode n : node.neighbors) {
			UndirectedGraphNode clone = helper(n);
			dup.neighbors.add(clone);
		}
		return dup;
	}

	public UndirectedGraphNode cloneGraph2(UndirectedGraphNode node) {
		if (node == null) return null;
		List<UndirectedGraphNode> nodes = getNodes(node);
		HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();

		for (UndirectedGraphNode n : nodes)
			map.put(n, new UndirectedGraphNode(n.label));

		for (UndirectedGraphNode cur : nodes) {
			UndirectedGraphNode tmp = map.get(cur);
			for (UndirectedGraphNode m : cur.neighbors)
				tmp.neighbors.add(map.get(m));
		}
		return map.get(node);
	}



	private List<UndirectedGraphNode> getNodes(UndirectedGraphNode node) {
		Queue<UndirectedGraphNode> queue = new LinkedList<>();
		Set<UndirectedGraphNode> set = new HashSet<>();
		queue.offer(node);
		set.add(node);

		while (!queue.isEmpty()) {
			UndirectedGraphNode cur = queue.poll();
			for (UndirectedGraphNode n : cur.neighbors) {
				if (!set.contains(n)) {
					set.add(n);
					queue.offer(n);
				}
			}
		}
		return new ArrayList<>(set);
	}
}
