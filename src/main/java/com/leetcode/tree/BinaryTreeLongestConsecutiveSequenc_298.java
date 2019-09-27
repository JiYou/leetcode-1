package com.leetcode.tree;

import common.TreeNode;

public class BinaryTreeLongestConsecutiveSequenc_298 {
	private int res = 0;

	public int longestConsecutive(TreeNode root) {
		if (root == null) return 0;
		helper(root, 0, root.value);
		return res;
	}

	private void helper(TreeNode node, int max, int target) {
		if (node == null) return;
		if (node.value == target)
			max++;
		else
			max = 1;
		Math.max(res, max);
		helper(node.left, max, node.value + 1);
		helper(node.right, max, node.value + 1);
	}
}
