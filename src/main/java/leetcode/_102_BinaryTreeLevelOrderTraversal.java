package leetcode;

import com.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _102_BinaryTreeLevelOrderTraversal {
	public static List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> levels = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int level = 0;

		while (!queue.isEmpty()) {
			levels.add(new ArrayList<>());
			int count = queue.size();
			for (int i = 0; i < count; i++) {
				TreeNode cur = queue.poll();
				levels.get(level).add(cur.value);
				if (cur.left != null)
					queue.offer(cur.left);
				if (cur.right != null)
					queue.offer(cur.right);
			}
			level++;
		}
		return levels;
	}

	public List<List<Integer>> levelOrder2(TreeNode root) {
		List<List<Integer>> levels = new ArrayList<>();
		helper(levels, root, 0);
		return levels;
	}

	private void helper(List<List<Integer>> levels, TreeNode node, int level) {
		if (levels.size() == level)
			levels.add(new ArrayList<>());

		levels.get(level).add(node.value);

		if (node.left != null)
			helper(levels, node.left, level + 1);
		if (node.right != null)
			helper(levels, node.right, level + 1);
	}

}
