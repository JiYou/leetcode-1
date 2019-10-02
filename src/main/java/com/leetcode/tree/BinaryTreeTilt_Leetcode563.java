package com.leetcode.tree;

import com.leetcode.common.TreeNode;

/**
 * Created by lhcxx on 19/4/23.
 */
public class BinaryTreeTilt_Leetcode563 {
	int res = 0;

	public int findTilt(TreeNode root) {
		helper(root);
		return res;
	}

	private int helper(TreeNode root) {
		if (root == null)
			return 0;
		int left = helper(root.left);
		int right = helper(root.right);
		res += Math.abs(left - right);
		return left + right + root.value;
	}
}
