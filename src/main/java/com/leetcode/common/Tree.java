package com.leetcode.common;

import java.util.LinkedList;
import java.util.Stack;

public class Tree {
	public void depthOrderTraversal(TreeNode root) {
		if (root == null)
			return;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			System.out.println(node.getValue() + " ");
			if (node.getRight() != null)
				stack.push(node.getRight());
			if (node.getLeft() != null)
				stack.push(node.getLeft());
		}
	}

	public void levelOrderTraversal(TreeNode root) {
		if (root == null)
			return;
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode node = queue.remove();
			System.out.println(node.getValue() + " ");
			if (node.getRight() != null)
				queue.add(node.getRight());
			if (node.getLeft() != null)
				queue.add(node.getLeft());
		}
	}
}
