package com.leetcode.tree;

import com.leetcode.common.TreeNode;

public class TrimBinarySearchTree_Leetcode669 {
	public TreeNode trimBST(TreeNode root, int l, int r) {
		if (root == null)
			return null;
		if (root.getValue() < l)
			return trimBST(root.getRight(), l, r);
		if (root.getValue() > r)
			return trimBST(root.getLeft(), l, r);
		root.setLeft(trimBST(root.getLeft(), l, r));
		root.setRight(trimBST(root.getRight(), l,r));
		return root;
	}
}
