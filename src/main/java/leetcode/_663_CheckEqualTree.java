package leetcode;

import com.leetcode.common.TreeNode;

public class _663_CheckEqualTree {
	public boolean checkEqualTree(TreeNode root) {
		if (root == null)
			return false;
		int sum = getSum(root);
		if (sum % 2 != 0)
			return false;
		return helper(root, sum / 2);
	}

	private boolean helper(TreeNode root, int sum) {
		if (root == null)
			return false;
		if (root.left != null && getSum(root.left) == sum)
			return true;
		if (root.right != null && getSum(root.right) == sum)
			return true;
		return helper(root.left, sum) || helper(root.right, sum);
	}


	private int getSum(TreeNode root) {
		if (root == null)
			return 0;
		return getSum(root.left) + getSum(root.right) + root.value;
	}


}
