package com.leetcode.tree;

import com.leetcode.common.TreeNode;

/**
 * Created by lhcxx on 18/9/24.
 */
public class LowestCommonAncestorOfBST_Leetcode235 {
	public TreeNode lowestCommonAncestor(TreeNode node1, TreeNode node2, TreeNode root) {
		if (root == null || node1 == null || node2 == null)
			return null;
		if (root.value > node1.value && root.value > node2.value)
			return lowestCommonAncestor(node1, node2, root.left);
		else if (root.value < node1.value && root.value < node2.value)
						return lowestCommonAncestor(node1, node2, root.right);
		else return root;
	}
}
