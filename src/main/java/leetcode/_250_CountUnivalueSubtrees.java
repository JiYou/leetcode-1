package leetcode;

import com.leetcode.common.TreeNode;

public class _250_CountUnivalueSubtrees {

	int res;

	public int countUnivalSubtrees(TreeNode root) {
		res = 0;
		helper(root);
		return res;
	}

	public boolean helper(TreeNode root) {
		if (root == null)
			return true;

		boolean left = helper(root.left);
		boolean right = helper(root.right);

		if (left && right) {
			if (root.left != null && root.value != root.left.value)
				return false;
			if (root.right != null && root.value != root.right.value)
				return false;
			res++;
			return true;
		}
		return false;
	}
}
