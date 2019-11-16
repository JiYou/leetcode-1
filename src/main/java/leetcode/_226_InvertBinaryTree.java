package leetcode;

import com.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class _226_InvertBinaryTree {
	public TreeNode invertTree(TreeNode root) {
		if(root == null)
			return root;
		TreeNode left = invertTree(root.left);
		TreeNode right = invertTree(root.right);
		root.left = right;
		root.right = left;
		return root;
	}

	public TreeNode invertTree2(TreeNode root) {
		if (root == null)
			return root;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			TreeNode cur = queue.poll();
			TreeNode tmp = cur.left;
			cur.left = cur.right;
			cur.right = tmp;
			if (cur.left != null) {
				queue.offer(cur.left);
			}
			if (cur.right != null) {
				queue.offer(cur.right);
			}
		}
		return root;
	}

}
