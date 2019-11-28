package leetcode;

import com.leetcode.common.TreeNode;

public class _623_AddOneRowToTree {
	public TreeNode addRowToTree(TreeNode root, int v, int d){
		if (d == 0 || d == 1) {
			TreeNode newRoot = new TreeNode(v);
			if (d == 1)
				newRoot.left = root;
			else
				newRoot.right = root;
			return newRoot;
		}

		if (root != null && d > 1) {
			root.left = addRowToTree(root.left, v, d > 2 ? d - 1: 1);
			root.right = addRowToTree(root.right, v, d > 2 ? d - 1 : 0);
		}
		return root;
	}


	public TreeNode addOneRow(TreeNode t, int v, int d) {
		if (d == 1) {
			TreeNode node = new TreeNode(v);
			node.left = t;
			return node;
		}

		insert(v, t, 1, d);
		return t;
	}

	private void insert(int val, TreeNode node, int depth, int n) {
		if (node == null)
			return;
		if (depth == n - 1) {
			TreeNode tmp = node.left;
			node.left = new TreeNode(val);
			node.left.left = tmp;
			tmp = node.right;
			node.right = new TreeNode(val);
			node.right.right = tmp;
		} else {
			insert(val, node.left, depth + 1, n);
			insert(val, node.right, depth + 1, n);
		}
	}
}
