package leetcode;

import com.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class _366_FindLeavesOfBinaryTree {
	public List<List<Integer>> findLeaves(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		helper(res, root);
		return res;
	}

	private int helper(List<List<Integer>> res, TreeNode root) {
		if (root == null)
			return -1;
		int left = helper(res, root.left);
		int right = helper(res, root.right);
		int level = Math.max(left, right) + 1;
		if (res.size() == level)
			res.add(new ArrayList<>());
		res.get(level).add(root.value);
		root.left = null;
		root.right = null;
		return level;
	}
}
