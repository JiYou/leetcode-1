package com.leetcode.tree;

import com.leetcode.common.TreeNode;

import java.util.*;

public class BinaryTreePostorderTraversal_145 {
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null)
			return res;
		helper(res, root);
		return res;
	}

	private void helper(List<Integer> list, TreeNode root) {
		if (root == null)
			return;
		helper(list, root.left);
		helper(list, root.right);
		list.add(root.value);
	}

	public List<Integer> postorderTraversal2(TreeNode root) {
		LinkedList<Integer> res = new LinkedList<>();
		if (root == null)
			return res;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode cur = stack.pop();
			res.addFirst(cur.value);
			if (cur.left != null) stack.push(cur.left);
			if (cur.right != null) stack.push(cur.right);
		}
		return res;
	}
}
