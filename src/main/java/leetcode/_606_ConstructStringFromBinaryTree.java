package leetcode;

import com.leetcode.common.TreeNode;

public class _606_ConstructStringFromBinaryTree {
	public String tree2Str(TreeNode root) {
		if (root == null)
			return "";
		if (root.left == null && root.right == null)
			return root.value + "";
		if (root.right == null)
			return root.value + "(" + tree2Str(root.left) + ")";
		return root.value + "(" + tree2Str(root.left) + ")" + "(" + tree2Str(root.right) + ")";
	}
}
