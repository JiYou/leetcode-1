package leetcode;

import com.leetcode.common.TreeNode;

public class _285_InorderSuccessorinBST {
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		TreeNode res = null;
		while (root != null) {
			if (root.value <= p.value)
				root = root.right;
			else {
				res = root;
				root = root.left;
			}
		}
		return res;
	}

	public TreeNode successor(TreeNode root, TreeNode p) {
		if (root == null)
			return null;
		if (root.value <= p.value)
			return successor(root.right, p);
		else {
			TreeNode tmp = successor(root.left, p);
			return tmp != null ? tmp : root;
		}
	}

}
