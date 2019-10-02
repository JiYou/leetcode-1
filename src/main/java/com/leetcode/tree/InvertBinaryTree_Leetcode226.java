package com.leetcode.tree;

import com.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by lhcxx on 18/9/23.
 */
public class InvertBinaryTree_Leetcode226 {
	public TreeNode invertTree(TreeNode root) {
		if (root == null)
			return null;
		TreeNode left = invertTree(root.getLeft());
		TreeNode right = invertTree(root.getRight());
		root.setLeft(right);
		root.setRight(left);
		return root;
	}

	public TreeNode invertTree2(TreeNode root) {
		if (root == null)
			return null;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			TreeNode tmp = node.left;
			node.left = node.right;
			node.right = tmp;
			if (node.getLeft() != null)
				queue.offer(node.getLeft());
			if (node.getRight() != null)
				queue.offer(node.getRight());
		}
		return root;
	}

}
