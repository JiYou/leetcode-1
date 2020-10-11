package leetcode;

import com.leetcode.common.TreeNode;

public class _124_maxPathSum {
	int maxSum = Integer.MIN_VALUE;
	public int maxPathSum(TreeNode root) {
		maxGain(root);
		return maxSum;
	}


	public int maxGain(TreeNode node) {
		if (node == null)
			return 0;

		int leftGain = Math.max(maxGain(node.left), 0);
		int rightGain = Math.max(maxGain(node.right), 0);

		int priceNewPath = node.value + leftGain + rightGain;
		maxSum = Math.max(maxSum, priceNewPath);

		return node.value + Math.max(leftGain, rightGain);
	}
}
