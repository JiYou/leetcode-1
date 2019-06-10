package com.leetcode.tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal_144 {
	public List<Integer> preorderTraversal(TreeNode root){
		List<Integer> res = new ArrayList<>();
		if (root == null)
			return res;
		helper(res, root);
		return res;
	}

	private void helper(List<Integer> list, TreeNode root) {
		if (root == null)
			return;
		list.add(root.value);
		helper(list, root.left);
		helper(list, root.right);
	}

	public List<Integer> preorderTraversal2(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null)
			return res;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode cur = stack.pop();
			if (cur.right != null) stack.push(cur.right);
			if (cur.left != null) stack.push(cur.left);
			res.add(cur.value);
		}
		return res;
	}


}
