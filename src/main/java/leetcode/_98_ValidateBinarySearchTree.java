package leetcode;

import com.leetcode.common.TreeNode;

public class _98_ValidateBinarySearchTree {
	public boolean isValidBST(TreeNode root) {
		if (root == null)
			return true;
		return helper(root, null, null);
	}

	private boolean helper(TreeNode root, Integer min, Integer max) {
		if (root == null)
			return true;
		if (min != null && root.value < min) return false;
		if (max != null && root.value > max) return false;

		return helper(root.left, min, root.value) && helper(root.right, root.value, max);
	}


}
