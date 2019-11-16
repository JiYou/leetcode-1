package leetcode;

import com.leetcode.common.ListNode;

public class _143_ReorderList {
	public void reorderList(ListNode head) {
		if (head == null || head.next == null)
			return;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode slow = head, fast = head, tmp = null;
		while (fast != null && fast.next != null) {
			tmp = slow;
			slow = slow.next;
			fast = fast.next.next;
		}

		tmp.next = null;
		ListNode l1 = reverse(tmp);
		merge(l1, head);
	}

	private ListNode reverse(ListNode head) {
		ListNode prev = null;
		while (head != null) {
			ListNode next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		return prev;
	}

	private void merge(ListNode l1, ListNode l2) {
		while (l1 != l2) {
			ListNode n1 = l1.next;
			ListNode n2 = l2.next;
			l1.next = l2;
			if (n1 == null)
				break;
			l2.next = n1;
			l1 = n1;
			l2 = n2;
		}
	}
}
