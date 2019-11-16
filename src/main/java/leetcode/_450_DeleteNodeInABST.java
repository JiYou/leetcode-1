package leetcode;

import com.leetcode.common.TreeNode;

public class _450_DeleteNodeInABST {
	public TreeNode deleteNode(TreeNode root, int key) {
		if (root == null) {
			return null;
		}
		if (root.value > key)
			return deleteNode(root.left, key);
		else if (root.value < key)
			return deleteNode(root.right, key);
		else {
			if (root.left == null)
				return root.right;
			else if (root.right == null)
				return root.left;
			TreeNode min = findMin(root.right);
			root.value = min.value;
			root.right = deleteNode(root.right, min.value);
		}
		return root;
	}

	private TreeNode findMin(TreeNode root) {
		if (root == null)
			return root;
		while (root.left != null)
			root = root.left;
		return root;
	}
}
