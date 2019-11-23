package leetcode;

import com.leetcode.common.TreeNode;

public class _617_MergeTwoBinaryTrees {
	public TreeNode mergeTwoBinaryTrees(TreeNode p1, TreeNode p2) {
		return merge(p1, p2);
	}

	private TreeNode merge(TreeNode p, TreeNode q) {
		if (p == null && q == null)
			return null;
		if (p == null && q != null)
			return q;
		if (p != null && q == null)
			return p;

		if (p != null && q != null) {
			p.value += q.value;
			p.left = merge(p.left, q.left);
			p.right = merge(p.right, q.right);
		}
		return p;
	}

}
