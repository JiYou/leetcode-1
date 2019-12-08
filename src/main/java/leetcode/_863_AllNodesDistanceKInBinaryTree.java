package leetcode;

import com.leetcode.common.TreeNode;

import java.util.*;

public class _863_AllNodesDistanceKInBinaryTree {
	private HashMap<TreeNode, List<TreeNode>> map = new HashMap<>();

	public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
		buildGraph(null, root);
		List<Integer> res = new ArrayList<>();
		HashSet<TreeNode> set = new HashSet<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(target);
		set.add(target);
		int k = 0;

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				if (k == K) {
					res.add(node.value);
				//	break;
				}
				for (TreeNode child : map.get(node)) {
					if (set.contains(child))
						continue;
					set.add(child);
					queue.offer(child);
				}
			}
			k++;
		}
		return res;
	}

	public void buildGraph(TreeNode parent, TreeNode child) {
		if (parent != null) {
			map.put(parent, map.getOrDefault(parent, new ArrayList<>())).add(child);
			map.put(child, map.getOrDefault(child, new ArrayList<>())).add(parent);
		}
		if (child.left != null)
			buildGraph(child, child.left);
		if (child.right != null)
			buildGraph(child, child.right);
	}
}
