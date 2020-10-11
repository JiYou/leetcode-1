package leetcode;

import com.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class _111_minDepth {
	public int minDepthDFS(TreeNode root) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return 1;

		int min = Integer.MAX_VALUE;

		if (root.left != null)
			min = Math.min(min, minDepthDFS(root.left));
		if (root.right != null)
			min = Math.min(min, minDepthDFS(root.right));
		return min + 1;
	}

	public int minDepthBFS(TreeNode root) {
		if (root == null)
			return 0;
		Queue<QueueNode> queue = new LinkedList<QueueNode>();
		queue.offer(new QueueNode(root,1));

		while(!queue.isEmpty()) {
			QueueNode cur = queue.poll();
			if (cur.node.left == null && cur.node.right == null)
				return cur.depth;
			if (cur.node.left != null)
				queue.offer(new QueueNode(cur.node.left, cur.depth + 1));
			if (cur.node.right != null)
				queue.offer(new QueueNode(cur.node.right, cur.depth + 1));
		}
		return 0;
	}

	class QueueNode {
		TreeNode node;
		int depth;

		public QueueNode(TreeNode node, int depth) {
			this.node = node;
			this.depth = depth;
		}
	}
}
