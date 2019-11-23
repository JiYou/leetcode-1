package leetcode;

import com.leetcode.common.TreeNode;

public class _606_ConstructStringFromBinaryTree {
	public String tree2Str(TreeNode root) {
		StringBuffer sb = new StringBuffer();
		helper(root, sb);
		return sb.toString()
	}

	private void helper(TreeNode root, StringBuffer sb) {
		if (root == null)
			return;
		sb.append(root.value);

		if (root.left != null && root.right != null) {
			sb.append("(");
			helper(root.left, sb);
			sb.append(")");
		}

		if (root.right != null) {
			sb.append("(");
			helper(root.right, sb);
			sb.append(")");
		}
	}
}
