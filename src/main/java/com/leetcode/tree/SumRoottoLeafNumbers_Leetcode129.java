package com.leetcode.tree;

import common.TreeNode;

/**
 * Created by lhcxx on 18/9/25.
 */
public class SumRoottoLeafNumbers_Leetcode129 {
	public int sumNumbers(TreeNode root) {
		helper(root, 0);
	}

	private int helper(TreeNode node, int num) {
		if (node == null)
			return 0;
		if (node.left == null && node.right == null)
			return 10 * num + node.value;
		return helper(node.left, num * 10 + node.value) +
			helper(node.right, num * 10 + node.value);
	}
}
