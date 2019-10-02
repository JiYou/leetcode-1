package com.leetcode.tree;

import com.leetcode.common.TreeNode;

/**
 * Created by lhcxx on 18/9/25.
 */
public class MinimumDepthofBinaryTree_Leetcode111 {
	public int minDepth(TreeNode root) {
		if (root == null)
			return 0;
		if (root.left == null || root.right == null)
			return Math.max(minDepth(root.left), minDepth(root.right)) + 1;
		return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
	}
}
