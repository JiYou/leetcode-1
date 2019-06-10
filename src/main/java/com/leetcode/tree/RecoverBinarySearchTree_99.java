package com.leetcode.tree;

import common.TreeNode;

import java.util.Stack;

public class RecoverBinarySearchTree_99 {


	TreeNode first = null;
	TreeNode second = null;
	TreeNode prev = null;

	public void recoverTree(TreeNode root) {
		if (root == null)
			return;
		helper(root);
		int tmp = first.value;
		first.value = second.value;
		second.value = tmp;
	}

	private void helper(TreeNode root) {
		if (root == null) return;
		helper(root.left);
		if (prev != null && prev.value > root.value) {
			if (first == null)
				first = prev;
			second = root;
		}
		prev = root;
		helper(root.right);
	}

	public void recoverTree2(TreeNode root) {
		TreeNode first = null, second = null, prev = null;

		Stack<TreeNode> stack = new Stack<>();
		TreeNode cur = root;
		while (!stack.isEmpty() || cur != null) {
			if (cur != null) {
				stack.push(cur);
				cur = cur.left;
			} else {
				cur = stack.pop();
				if (prev != null && prev.value > cur.value) {
					if (first == null)
						first = prev;
					second = cur;
				}
				prev = cur;
				cur = cur.right;
			}
		}
		int tmp = first.value;
		first.value = second.value;
		second.value = tmp;
	}
}
