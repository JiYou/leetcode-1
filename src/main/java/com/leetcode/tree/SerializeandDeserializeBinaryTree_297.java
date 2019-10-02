package com.leetcode.tree;

import com.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeandDeserializeBinaryTree_297 {
	public String serialize(TreeNode root) {
		if (root == null) return "";
		StringBuffer sb = new StringBuffer();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode cur = queue.poll();
			if (cur == null) {
				sb.append("null ");
				continue;
			}
			sb.append(cur.value + " ");
			queue.offer(cur.left);
			queue.offer(cur.right);
		}
		return sb.toString();
	}

	public TreeNode deserialize(String data) {
		if (data == "")
			return null;
		String[] node = data.split(" ");
		TreeNode root = new TreeNode(Integer.parseInt(node[0]));
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		for (int i = 1; i < node.length; i++) {
			TreeNode cur = queue.poll();
			if (node[i] != "null") {
				cur.left = new TreeNode(Integer.parseInt(node[i]));
				queue.offer(cur.left);
			}
			if (node[++i] != "null") {
				cur.right = new TreeNode(Integer.parseInt(node[i]));
				queue.offer(cur.right);
			}
		}
		return root;
	}

}
