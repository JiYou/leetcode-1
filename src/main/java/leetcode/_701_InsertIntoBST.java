package leetcode;

import com.leetcode.common.TreeNode;

public class _701_InsertIntoBST {
	public TreeNode insertIntoBST(TreeNode root, int val) {
		if (root == null)
			return new TreeNode(val);
		TreeNode cur = root;
		TreeNode pre = null;
		while (cur != null) {
			pre = cur;
			if (cur.value > val) {
				cur = cur.left;
				if (cur == null) {
					pre.left = new TreeNode(val);
				}
			} else {
				cur = cur.right;
				if (cur == null) {
					pre.right = new TreeNode(val);
				}
			}
		}
		return root;
	}


}
