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
}
