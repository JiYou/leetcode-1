package leetcode;

import com.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class _513_FindBottomLeftTreeValue {
	public int findBottomLeftTreeValue(TreeNode root) {
		if (root == null)
			return -1;
		int res = 0;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode cur = queue.poll();
			res = cur.value;
			if (cur.right != null)
				queue.offer(cur.right);
			if (cur.left != null)
				queue.offer(cur.left);
		}
		return res;
	}
}
