package com.leetcode.tree;

import com.leetcode.common.TreeNode;

public class ConvertBinarySearchTreetoSortedDoublyLinkedList_426 {
	private TreeNode first = null;
	private TreeNode last = null;

	public TreeNode treeToDoubleList(TreeNode root) {
		if (root == null) return root;
		helper(root);
		last.right = first;
		first.left = last;
		return first;
	}

	private void helper(TreeNode node) {
		if (node == null)
			return;
		helper(node.left);
		if (last != null) {
			node.left = last;
			last.right = node;
		} else {
			first = node;
		}
		last = node;
		helper(node.right);
	}
}
