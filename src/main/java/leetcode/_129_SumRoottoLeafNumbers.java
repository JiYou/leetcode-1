package leetcode;

import com.leetcode.common.TreeNode;

public class _129_SumRoottoLeafNumbers {
	public int sumNumbers(TreeNode root) {
		return helper(root, 0);
	}

	public int helper(TreeNode root, int num) {
		if (root == null)
			return 0 ;
		if (root.left == null && root.right == null)
			return num * 10 + root.value;
		int left = helper(root.left, num * 10 + root.value);
		int right = helper(root.right, num * 10 + root.value);
		return left + right;
	}
}
