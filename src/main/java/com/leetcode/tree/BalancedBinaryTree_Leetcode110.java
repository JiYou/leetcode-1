package com.leetcode.tree;

public class BalancedBinaryTree_Leetcode110 {
	public boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;
		return Math.abs(height(root.getLeft()) - height(root.getRight())) <= 1 && isBalanced(root.getLeft()) && isBalanced(root.getRight());
	}

	private int height(TreeNode root) {
		if (root == null)
			return 0;
		return Math.max(height(root.getLeft()), height(root.getRight())) + 1;
	}
}
