package com.leetcode.tree;

import com.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView_Leetcode199 {
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) return res;
		helper(res, root,0);
		return res;
	}

	private void helper(List<Integer> res, TreeNode root, int level) {
		if (root == null)
			return;
		if (res.size() == level)
			res.add(root.value);
		helper(res, root.right, level + 1);
		helper(res, root.left, level + 1);
	}
}
