package com.leetcode.tree;

import com.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class FindLeavesOfBinaryTree_Leetcode366 {
	public List<List<Integer>> findLeaves(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();

	}

	private int helper(List<List<Integer>>res, TreeNode root) {
		if (root == null)
			return -1;
		int left = helper(res, root.left);
		int right = helper(res, root.right);

	}
}


