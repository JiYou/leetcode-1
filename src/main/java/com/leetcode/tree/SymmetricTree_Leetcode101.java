package com.leetcode.tree;

import com.leetcode.common.TreeNode;

/**
 * Created by lhcxx on 18/9/25.
 */
public class SymmetricTree_Leetcode101 {
	public boolean isSymmetricTree(TreeNode root) {
		if (root == null)
			return true;
		return helper(root.left, root.right);
	}

	private boolean helper(TreeNode left, TreeNode right) {
		if (left == null && right == null)
			return true;
		if (left == null || right == null)
			return false;
		if (left != right)
			return false;
		return helper(left.left, right.right) && helper(left.right, right.left);
	}
}
