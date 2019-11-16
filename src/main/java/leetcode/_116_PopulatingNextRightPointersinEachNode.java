package leetcode;

import com.leetcode.common.LinkedTreeNode;
import com.leetcode.common.TreeNode;

public class _116_PopulatingNextRightPointersinEachNode {
	public void connect(LinkedTreeNode root) {
		if (root == null)
			return;
		if (root.left != null)
			root.left.next = root.right;
		if (root.right != null && root.next != null)
			root.right.next = root.next.left;
		connect(root.left);
		connect(root.right);
	}

	public void connect2(LinkedTreeNode root) {
		LinkedTreeNode start = root;

		while (start != null) {
			LinkedTreeNode cur = start;
			while (cur != null) {
				if (cur.left != null)
					cur.left.next = cur.right;
				if (cur.next != null && cur.right != null)
					cur.right.next = cur.next.left;
				cur = cur.next;
			}
			start = start.left;
		}
	}
}
