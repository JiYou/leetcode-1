package leetcode;

import com.leetcode.common.TreeNode;

public class _510_InorderSuccessor {
	public TreeNode inorderSuccessor(TreeNode root) {
		if (root == null)
			return root;
		TreeNode res = root;
		if (root.right != null) {
			res = res.right;
			while (res.left != null)
				res = res.left;
		} else {
			res = root.parent;
			while (res != null && res.value < root.value)
				res = res.parent;
		}
		return res;
	}

	public TreeNode inorderSuccessor2(TreeNode x) {
		if (x.right != null) {
			x = x.right;
			while (x.left != null)
				x = x.left;
			return x;
		}

		while (x.parent != null && x == x.parent.right)
			x = x.parent;
		return x.parent;
	}

	public TreeNode inorderSuccessor3(TreeNode x) {
		if (x.right != null)
			return findMin(x.right);

		while (x.parent != null && x == x.parent.right)
			x = x.parent;
		return x.parent;
	}

	private TreeNode findMin(TreeNode node) {
		while (node.left != null)
			node = node.left;
		return node;
	}
}
