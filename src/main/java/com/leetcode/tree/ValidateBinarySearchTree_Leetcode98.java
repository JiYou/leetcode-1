package com.leetcode.tree;

import common.TreeNode;

/**
 * Created by lhcxx on 18/9/25.
 */
public class ValidateBinarySearchTree_Leetcode98 {
	public boolean isValidateBST(TreeNode root) {
		if (root == null)
			return true;
		return helper(root, null, null);
	}

	private boolean helper(TreeNode root, Integer min, Integer max) {
		if (root == null)
			return true;
		if (min != null && root.value <= min) return false;
		if (max != null && root.value >= max) return false;
		return helper(root.left, min, root.value) && helper(root.right, root.value, max);
	}
}

