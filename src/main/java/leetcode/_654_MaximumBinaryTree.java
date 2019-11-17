package leetcode;

import com.leetcode.common.TreeNode;

public class _654_MaximumBinaryTree {
	public TreeNode constructMaximumBinaryTree(int[] nums) {
		return constructMaximumBinaryTree(nums, 0, nums.length - 1);
	}

	private TreeNode constructMaximumBinaryTree(int[] nums, int left, int right) {
		if (left > right)
			return null;
		int index = findMax(nums, left, right);
		TreeNode root = new TreeNode(nums[index]);
		root.left = constructMaximumBinaryTree(nums, left, index - 1);
		root.right = constructMaximumBinaryTree(nums, index + 1, right);
		return root;
	}

	private int findMax(int[] nums, int left, int right) {
		if (left == right)
			return left;

		int max = nums[left];
		int res = left;

		for (int i = left + 1; i <= right; i++) {
			if (nums[i] > max) {
				res = i;
				max = nums[i];
			}
		}
		return res;
	}


}
