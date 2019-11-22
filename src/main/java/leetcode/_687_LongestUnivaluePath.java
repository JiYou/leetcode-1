package leetcode;

import com.leetcode.common.TreeNode;

public class _687_LongestUnivaluePath {

	int res = 0;

	public int longestUnivaluePath(TreeNode root) {
		res = 0;
		helper(root);
		return res;
	}

	private int helper(TreeNode root) {
		if (root == null)
			return 0;

		int left = helper(root.left);
		int right = helper(root.right);

		int l = 0, r = 0;

		if (root.left != null && root.left.value == root.value)
			l = left + 1;

		if (root.right != null && root.right.value == root.value)
			r = right + 1;

		res = Math.max(res, l + r);
		return Math.max(l, r);
	}

}
