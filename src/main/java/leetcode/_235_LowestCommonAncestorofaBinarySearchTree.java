package leetcode;

import com.leetcode.common.TreeNode;

public class _235_LowestCommonAncestorofaBinarySearchTree {
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root.value > p.value && root.value > q.value)
			return lowestCommonAncestor(root.left, p, q);
		else if (root.value < q.value && root.value < p.value)
			return lowestCommonAncestor(root.right, p, q);
		return root;
	}
}

