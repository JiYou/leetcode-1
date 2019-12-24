package leetcode;

import com.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _94_BinaryTreeInorderTraversal {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		helper(res, root);
		return res;
	}

	private void helper(List<Integer>res, TreeNode node) {
		if (node == null)
			return;
		helper(res, node.left);
		res.add(node.value);
		helper(res, node.right);
	}

	public List<Integer> inorderTraversal2(TreeNode root) {
		if (root == null)
			return null;
		List<Integer> res = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();

		TreeNode cur = root;
		while (cur != null || !stack.isEmpty()) {
			while (cur != null) {
				stack.push(cur);
				cur = cur.left;
			}

			cur = stack.pop();
			res.add(cur.value);
			cur = cur.right;
		}

		return res;
	}
}
