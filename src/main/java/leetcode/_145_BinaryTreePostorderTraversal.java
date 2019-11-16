package leetcode;

import com.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class _145_BinaryTreePostorderTraversal {
	public List<Integer> postorderTraversal(TreeNode root){
		List<Integer> res = new ArrayList<>();
		helper(res, root);
		return res;
	}

	private void helper(List<Integer>res, TreeNode node) {
		if (node == null)
			return;
		helper(res, node.left);
		helper(res, node.right);
		res.add(node.value);
	}

	public static List<Integer> postorderTraversal2(TreeNode root) {
		LinkedList<Integer> res = new LinkedList<>();
		if (root == null) return res;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode cur = stack.pop();
			res.addFirst(cur.value);
			if (cur.left != null) stack.push(cur.left);
			if (cur.right != null) stack.push(cur.right);
		}
		return res;
	}

	public static List<Integer> postorderTraversal3(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) return res;
		Stack<TreeNode> stack = new Stack<>();
		TreeNode cur = root;
		TreeNode last = null;

		while (cur != null) {
			stack.push(cur);
			cur = cur.left;
		}

		while (!stack.isEmpty()) {
			cur = stack.pop();
			if (cur.right != null && cur.right != last) {
				stack.push(cur);
				cur = cur.right;
				while (cur != null) {
					stack.push(cur.left);
					cur = cur.left;
				}
			} else {
				res.add(cur.value);
				last = cur;
			}
		}
		return res;
	}
}
