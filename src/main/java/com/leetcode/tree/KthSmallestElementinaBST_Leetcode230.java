package com.leetcode.tree;

import com.leetcode.common.TreeNode;

/**
 * Created by lhcxx on 18/9/24.
 */
public class KthSmallestElementinaBST_Leetcode230 {

	private int count;
	private int res;

	public int KthSmallest(TreeNode root, int k) {
		count = k;
		helper(root);
		return res;
	}

	private void helper(TreeNode root) {
		if (root == null)
			return;
		helper(root.left);
		count--;
		if (count == 0)
			res = root.value;
		helper(root.right);
	}
}
