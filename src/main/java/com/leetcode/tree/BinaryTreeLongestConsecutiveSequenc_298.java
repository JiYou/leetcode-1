package com.leetcode.tree;

import common.TreeNode;

public class BinaryTreeLongestConsecutiveSequenc_298 {
	private int res = 0;

	public int longestConsecutive(TreeNode root) {
		if (root == null)
			return 0;
		helper(root, 0, root.value);
		return res;
	}

	private void helper(TreeNode root, int max, int target) {
		if (root == null)
			return;
		if (root.value == target)
			max++;
		else
			max = 1;
		res = Math.max(res, max);
		helper(root.left, max, root.value + 1);
		helper(root.right, max, root.value + 1);
	}
}
