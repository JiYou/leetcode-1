package com.leetcode.tree;

import common.LinkedTreeNode;

/**
 * Created by lhcxx on 18/9/25.
 */
public class PopulatingNextRightPointersinEachNode_Leetcode116 {
	public void connect(LinkedTreeNode root) {
		if (root == null)
			return;
		if (root.left != null)
			root.left.next = root.right;
		if (root.next != null && root.right != null)
			root.right.next = root.next.left;
		connect(root.left);
		connect(root.right);
	}
}
