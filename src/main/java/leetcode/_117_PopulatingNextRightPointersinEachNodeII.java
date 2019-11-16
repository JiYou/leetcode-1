package leetcode;

import com.leetcode.common.LinkedTreeNode;

public class _117_PopulatingNextRightPointersinEachNodeII {
	public void connect(LinkedTreeNode root) {
		LinkedTreeNode cur = root, pre = null, head = null;
		while (cur != null) {
			while (cur != null) {
				if (cur.left != null) {
					if (pre != null)
						pre.next = cur.left;
					else
						head = cur.left;
					pre = cur.left;
				}
				if (cur.right != null) {
					if (pre != null)
						pre.next = cur.right;
					else
						head = cur.right;
					cur = cur.right;
				}
				cur = cur.next;
			}
			cur = head;
			head = null;
			pre = null;
		}
	}
}
