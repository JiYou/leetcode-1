package leetcode;

import com.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class _958_CompleteTree {
	public boolean isCompleteTree(TreeNode root) {
		if (root == null)
			return true;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		boolean occurNull = false;

		TreeNode cur = null;
		while (!queue.isEmpty()) {
			cur = queue.poll();
			if (cur == null) {
				occurNull = true;
				continue;
			}
			if (occurNull)
				return false;
			queue.offer(cur.left);
			queue.offer(cur.right);
		}
		return true;
	}
}
