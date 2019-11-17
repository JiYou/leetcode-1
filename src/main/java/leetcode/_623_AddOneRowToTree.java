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
}
