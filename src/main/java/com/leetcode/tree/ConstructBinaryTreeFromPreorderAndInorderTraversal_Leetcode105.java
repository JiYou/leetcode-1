package com.leetcode.tree;

import common.TreeNode;

/**
 * Created by lhcxx on 18/9/22.
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal_Leetcode105 {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		return buildTreeHelper(0, 0, inorder.length - 1, preorder, inorder);
	}

	private TreeNode buildTreeHelper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
		if (preStart > preorder.length - 1 || inStart > inEnd)
			return null;
		TreeNode root = new TreeNode(preorder[preStart]);
		int inIndex = 0;
		for (int i = inStart; i <= inEnd; i++)
			if (root.getValue() == inorder[i])
				inIndex = i;

		root.setLeft(buildTreeHelper(preStart + 1, inStart, inIndex - 1, preorder, inorder));
		root.setRight(buildTreeHelper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder));
		return root;
	}
}
