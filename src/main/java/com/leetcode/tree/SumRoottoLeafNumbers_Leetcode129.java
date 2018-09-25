package com.leetcode.tree;

import common.TreeNode;

/**
 * Created by lhcxx on 18/9/25.
 */
public class SumRoottoLeafNumbers_Leetcode129 {
	public int sumNumber(TreeNode root) {
		return helper(root, 0);
	}

	private int helper(TreeNode root, int num) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return num * 10 + root.value;
		return helper(root.left, num * 10 + root.value) + helper(root.right, num * 10 + root.value);
	}
}
