package com.leetcode.tree;

import com.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths_Leetcode257 {
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> res = new ArrayList<>();
		if (root == null)
			return res;
		findPath(res, root, "");
		return res;
	}

	private void findPath(List<String> res, TreeNode node, String path) {
		if (node.getLeft() == null && node.getRight() == null)
			res.add(path + node.getValue());
		if (node.getLeft() != null)
			findPath(res, node.getLeft(), path + node.getValue() + "->");
		if (node.getRight() != null)
			findPath(res, node.getRight(), path + node.getValue() + "->");
	}
}
