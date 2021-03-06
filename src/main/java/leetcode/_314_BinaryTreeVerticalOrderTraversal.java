package leetcode;

import com.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _314_BinaryTreeVerticalOrderTraversal {

	private int min = 0;
	private int max = 0;

	public List<List<Integer>> verticalOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null)
			return res;
		helper(root, 0);
		Queue<TreeNode> queue = new LinkedList<>();
		Queue<Integer> index = new LinkedList<>();
		queue.offer(root);
		index.offer(-min);

		for (int i = min; i <= max; i++)
			res.add(new ArrayList<>());

		while (!queue.isEmpty()) {
			TreeNode cur = queue.poll();
			int idx = index.poll();
			res.get(idx).add(cur.value);
			if (cur.left != null) {
				queue.offer(cur.left);
				index.offer(idx - 1);
			}
			if (cur.right != null) {
				queue.offer(cur.right);
				index.offer(idx + 1);
			}
		}
		return res;
	}

	private void helper(TreeNode root, int idx) {
		if (root == null)
			return;
		min = Math.min(min, idx);
		max = Math.max(max, idx);
		helper(root.left, idx - 1);
		helper(root.right, idx + 1);
	}
}
