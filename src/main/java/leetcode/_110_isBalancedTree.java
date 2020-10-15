package leetcode;

import com.leetcode.common.TreeNode;

public class _110_isBalancedTree {
	public boolean isBalanced1(TreeNode root) {
		if (root == null)
			return true;
		return Math.abs(fromTop(root.left) - fromTop(root.right)) <= 1 && isBalanced1(root.left) && isBalanced1(root.right);
	}

	private int fromTop(TreeNode root) {
		if (root == null)
			return 0;
		return Math.max(fromTop(root.left), fromTop(root.right)) + 1;
	}

	public boolean isBalanced2(TreeNode root) {
		return fromGround(root) >= 0;
	}

	private int fromGround(TreeNode root) {
		if (root == null)
			return 0;
		int leftHeight = fromGround(root.left);
		int rightHeight = fromGround(root.right);
		if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1)
			return -1;
		return Math.max(leftHeight, rightHeight) + 1;
	}

	private int fromGround2(TreeNode root) {
		if (root == null)
				return 0;
		int left = fromGround2(root.left);
		if (left == -1) return -1;
		int right = fromGround2(root.right);
		if (right == -1) return -1;

		return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
	}

}
