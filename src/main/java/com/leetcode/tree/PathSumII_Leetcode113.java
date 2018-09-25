package com.leetcode.tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lhcxx on 18/9/25.
 */
public class PathSumII_Leetcode113 {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null)
			return res;
		helper(res, new ArrayList<>(), root, sum);
		return res;
	}

	private void helper(List<List<Integer>> res, List<Integer> list, TreeNode root, int sum) {
		if (root == null)
			return;
		list.add(root.value);
		if (root.left == null && root.right == null) {
			if (sum == root.value)
				res.add(list);
		}
		helper(res, list, root.left, sum - root.value);
		helper(res, list, root.right, sum - root.value);
		list.remove(list.size() - 1);
	}
}
