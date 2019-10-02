package com.leetcode.tree;

import com.leetcode.common.TreeNode;

/**
 * Created by lhcxx on 18/9/22.
 */
public class ConstructBinaryTreefromInorderAndPostorderTraversal_Leetcode106 {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		return buildTreeHelper(0, postorder.length - 1, 0, inorder.length - 1, inorder, postorder);
	}

	private TreeNode buildTreeHelper(int postStart, int postEnd, int inStart, int inEnd, int[] inorder, int[] postorder) {

		if (postEnd < 0 || inStart > inEnd) {
			return null;
		}

		TreeNode root = new TreeNode(postorder[postEnd]);
		int inIndex = 0;
		for (int i = inStart; i <= inEnd; i++)
			if (inorder[i] == root.getValue())
				inIndex = i;

		root.setLeft(buildTreeHelper(postStart, postStart + inIndex - inStart - 1, inStart, inIndex - 1, inorder, postorder));
		root.setRight(buildTreeHelper(postEnd - inEnd + inIndex, postEnd - 1, inIndex + 1, inEnd, inorder, postorder));
		return root;
	}
}
