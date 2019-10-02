package com.leetcode.tree;

import com.leetcode.common.TreeNode;

/**
 * Created by lhcxx on 18/9/22.
 */
public class ConvertSortedArrayToBinarySearchTree_Leetcode108 {
	public TreeNode convertTree(int[] nums) {
		if (nums == null || nums.length == 0)
			return null;
		return  covert(nums, 0, nums.length - 1);
	}

	private TreeNode covert(int[] nums, int left, int right) {
		if (left > right)
			return null;
		int mid = (left+right) / 2;
		TreeNode root = new TreeNode(nums[mid]);
		root.setLeft(covert(nums, left, mid - 1));
		root.setRight(covert(nums, mid + 1, right));
		return root;
	}
}
