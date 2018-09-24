package com.leetcode.tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by lhcxx on 18/9/22.
 */
public class BinaryTreeZigzagLevelOrderTraversal_Leetcode103 {
	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null)
			return res;
		Queue<TreeNode> queue = new LinkedList<>();
		boolean flag = true;
		queue.offer(root);
		while (!queue.isEmpty()) {
			List<Integer> list = new ArrayList<>();
			TreeNode node = queue.poll();
			for (int i = 0; i < queue.size(); i++) {
				if (flag)
					list.add(node.getValue());
				else
					list.add(0, node.getValue());
				if (node.getLeft() != null)
					queue.offer(node.getLeft());
				if (node.getRight() != null)
					queue.offer(node.getRight());
			}
			res.add(list);
			flag = flag ? false:true;
		}
		return res;
	}
}
