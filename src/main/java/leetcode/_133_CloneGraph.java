package leetcode;

import com.leetcode.common.UndirectedGraphNode;

import java.util.HashMap;

public class _133_CloneGraph {
	HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		return helper(node);
	}

	private UndirectedGraphNode helper(UndirectedGraphNode node){
		if (node == null)
			return null;
		if (map.containsKey(node))
			return map.get(node);
		UndirectedGraphNode dup = new UndirectedGraphNode(node.label);
		map.put(node, dup);
		for (UndirectedGraphNode n : node.neighbors) {
			UndirectedGraphNode copy = helper(n);
			dup.neighbors.add(copy);
		}
		return dup;
	}

}
