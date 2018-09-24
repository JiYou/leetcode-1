package com.leetcode.tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetcodeTree {
	public boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;
		return Math.abs(height(root.getLeft()) - height(root.getRight())) <= 1
			&& isBalanced(root.getLeft()) && isBalanced(root.getRight());
	}

	private int height(TreeNode root) {
		if (root == null)
			return 0;
		return Math.max(height(root.getLeft()), height(root.getRight())) + 1;
	}

	private List<Integer> preorederTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null)
			return null;

		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode p = root;

		while (p != null || !stack.empty()) {
			while (p != null) {
				result.add(p.getValue());
				stack.push(p);
				p = p.getLeft();
			}
			if (!stack.empty()){
				p = stack.pop();
				p = p.getRight();
				}
			}
			return  result;
	}


	private boolean failed = false;
	private long last = Long.MIN_VALUE;

	public boolean isValidBST(TreeNode root) {
		if (root == null)
			return true;
		inorderBST(root);
		return !failed;
	}

	private void inorderBST(TreeNode root) {
		if (root == null || failed)
			return;

		inorderBST(root.getLeft());
		if (last > root.getValue())
			failed = true;

		last = root.getValue();
		inorderBST(root.getRight());
	}








}
