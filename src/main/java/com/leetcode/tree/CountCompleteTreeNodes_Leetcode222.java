package com.leetcode.tree;

import common.TreeNode;

/**
 * Created by lhcxx on 18/9/23.
 */
public class CountCompleteTreeNodes_Leetcode222 {
	public int countNodes(TreeNode root) {
		if (root == null)
			return 0;
		int left = depthLeft(root);
		int right = depthRight(root);
		if (left == right)
			return (1 << left) - 1;
		else
			return (countNodes(root.getLeft()) + countNodes(root.getRight()) + 1);
	}

	private int depthLeft(TreeNode node) {
		int res = 0;
		while (node.getLeft() != null) {
			node.setLeft(node.getLeft());
			res++;
		}
		return res;
	}

	private int depthRight(TreeNode node) {
		int res = 0;
		while (node.getRight() != null) {
			node.setRight(node.getRight());
			res++;
		}
		return res;
	}
}
