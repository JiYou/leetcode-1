package leetcode;

import com.leetcode.common.ListNode;
import com.leetcode.common.TreeNode;

public class _109_ConvertSortedListtoBinarySearchTree {
	public TreeNode sortedListToBST(ListNode head) {
		if (head == null)
			return null;
		return toBST(head, null);
	}

	public TreeNode toBST(ListNode head, ListNode tail) {
		if (head == null) return null;
		ListNode fast = head, slow = head;
		while (fast != tail && fast.next != tail) {
			fast = fast.next.next;
			slow = slow.next;
		}

		TreeNode root = new TreeNode(slow.val);
		root.left = toBST(head, slow);
		root.right = toBST(slow.next, tail);
		return root;
	}
}
