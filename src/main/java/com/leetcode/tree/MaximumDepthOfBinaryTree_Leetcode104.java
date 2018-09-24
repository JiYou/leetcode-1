package com.leetcode.tree;

import common.TreeNode;

/**
 * Created by lhcxx on 18/9/24.
 */
public class MaximumDepthOfBinaryTree_Leetcode104 {
	public int maxDepth(TreeNode root) {
		if (root == null)
			return 0;
		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	}
}
