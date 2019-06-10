package com.leetcode.tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal_94 {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null)
			return res;
		helper(root, res);
		return res;
	}

	private void helper(TreeNode root, List<Integer> res) {
		if (root == null)
			return;
		helper(root.left, res);
		res.add(root.value);
		helper(root.right, res);
	}

	public List<Integer> inorderTraversal2(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null)
			return res;
		Stack<TreeNode> stack = new Stack<>();
		TreeNode cur = root;
		while (!stack.isEmpty() || cur != null) {
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
