package leetcode;

import com.leetcode.common.TreeNode;

public class _450_DeleteNodeInABST {
	public TreeNode deleteNode(TreeNode root, int key) {
		if (root == null) {
			return null;
		}
		if (root.value > key)
			root.left = deleteNode(root.left, key);
		else if (root.value < key)
			root.right = deleteNode(root.right, key);
		else {
			if (root.left == null && root.right == null)
				root = null;
			else if (root.right != null) {
				root.value = successor(root.right);
				root.right = deleteNode(root.right, root.value);
			} else {
				root.value = predecessor(root.left);
				root.left = deleteNode(root.left, root.value);
			}
		}
		return root;
	}

	private int successor(TreeNode root) {
		//root = root.right;
		while (root.left != null)
			root = root.left;
    return root.value;
	}

	public int predecessor(TreeNode root) {
		while (root.right != null)
			root = root.right;
		return root.value;
	}

	private TreeNode findMin(TreeNode root) {
		if (root == null)
			return root;
		while (root.left != null)
			root = root.left;
		return root;
	}
}
