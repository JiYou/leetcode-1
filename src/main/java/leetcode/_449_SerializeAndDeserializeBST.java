package leetcode;

import com.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class _449_SerializeAndDeserializeBST {
	public String serialize(TreeNode root) {
		if (root == null) return "";
		StringBuffer sb = new StringBuffer();
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			sb.append(node.value + " ");
			if (node.right != null)
				stack.push(node.right);
			if (node.left != null)
				stack.push(node.left);
		}
		return sb.toString();
	}


	public TreeNode deserialize(String data) {
		if (data == null || data.length() == 0)
			return null;
		String[] strs = data.split(" ");
		Queue<Integer> queue = new LinkedList<>();
		for (String s : strs)
			queue.offer(Integer.parseInt(s));
		return getNode(queue);
	}

	private TreeNode getNode(Queue<Integer> queue) {
		if (queue.isEmpty()) return null;
		TreeNode root = new TreeNode(queue.poll());
		Queue<Integer> small = new LinkedList<>();
		while (!queue.isEmpty() && queue.peek() <root.value)
			small.offer(queue.poll());
		root.left = getNode(small);
		root.right = getNode(queue);
		return root;
	}
}
