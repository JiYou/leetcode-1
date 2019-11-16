package leetcode;

import com.leetcode.common.TreeNode;

import java.util.Stack;

public class _173_BinarySearchTreeIterator {
	private TreeNode cur;
	private Stack<TreeNode> stack;

	public _173_BinarySearchTreeIterator(TreeNode root) {
		cur = root;
		stack = new Stack<>();
	}

	public boolean hasNext() {
		if (!stack.isEmpty() || cur != null)
			return true;
		return false;
	}

	public int next() {
		while (cur != null){
			stack.push(cur);
			cur = cur.left;
		}
		cur = stack.pop();
		int val = cur.value;
		cur = cur.right;
		return val;
	}
}
