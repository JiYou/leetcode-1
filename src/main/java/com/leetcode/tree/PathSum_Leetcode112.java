package com.leetcode.tree;

import com.leetcode.common.TreeNode;

import java.util.Stack;

/**
 * Created by lhcxx on 18/9/25.
 */
public class PathSum_Leetcode112 {
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null)
			return false;
		if (root.left == null && root.right == null)
			return sum == root.value;
		return hasPathSum(root.left, sum - root.value) || hasPathSum(root.right, sum - root.value);
	}

	public boolean hasPathSum2(TreeNode root, int sum) {
		if (root == null)
			return false;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			if (node.left == null && node.right == null)
				return node.value == sum;
			if (node.left != null) {
				stack.push(node.left);
				sum -= node.value;
			}
			if (node.right != null) {
				stack.push(node.right);
				sum -= node.value;
			}
		}
		return false;
	}
}
