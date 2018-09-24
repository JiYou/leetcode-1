package com.leetcode.tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView_Leetcode199 {
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null)
			return res;
		levelTravelsal(root, res, 0);
		return res;
	}

	private void levelTravelsal(TreeNode root, List<Integer> res, int level) {
		if (root == null)
			return;
		if (res.size() == level)
			res.add(root.getValue());
		levelTravelsal(root.getRight(), res, level + 1);
		levelTravelsal(root.getLeft(), res, level + 1);
	}
}
