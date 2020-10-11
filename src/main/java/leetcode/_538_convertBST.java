package leetcode;

import com.leetcode.common.TreeNode;

public class _538_convertBST {

	private int sum = 0;

	public TreeNode convertBST(TreeNode root) {
		if (root == null)
			return null;
		helper(root);
		return root;
	}

	private void helper(TreeNode node) {
		if (node == null)
			return;
		helper(node.right);

		sum += node.value;
		node.value = sum;

		helper(node.left);
	}
}
