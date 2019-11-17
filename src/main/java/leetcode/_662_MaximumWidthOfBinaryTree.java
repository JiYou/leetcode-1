package leetcode;

import com.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class _662_MaximumWidthOfBinaryTree {
	public int widthOfBinaryTree(TreeNode root) {
		if (root == null)
			return 0;
		Queue<TreeNode> queue = new LinkedList<>();
		Queue<Integer> indice = new LinkedList<>();
		queue.offer(root);
		indice.offer(0);
		int max = 1, leftMost = 0, rightMost = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode cur = queue.poll();
				int index = indice.poll();
				if (i == 0) leftMost = index;
				if (i == size - 1) rightMost = index;
				if (cur.left != null) {
					queue.offer(cur.left);
					indice.offer(index * 2);
				}
				if (cur.right != null) {
					queue.offer(cur.right);
					indice.offer(index * 2 + 1);
				}
			}
			max = Math.max(max, rightMost - leftMost + 1);
		}
		return max;
	}
}
