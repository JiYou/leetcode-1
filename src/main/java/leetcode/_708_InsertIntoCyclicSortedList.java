package leetcode;

import com.leetcode.common.ListNode;

public class _708_InsertIntoCyclicSortedList {
	public ListNode insert(ListNode head, int val) {
		if (head == null) {
			ListNode tmp = new ListNode(val);
			head = tmp;
			head.next = null;
			return head;
		}

		ListNode cur = head, tmp = null;

		while (true) {
			if (cur.val < cur.next.val) {
				if (cur.val <= val && val <= cur.next.val) {
					ListNode newNode = new ListNode(val);
					tmp = cur.next;
					cur.next = newNode;
					newNode.next = tmp;
					break;
				}
			}else if (cur.val > cur.next.val) {
					if (cur.val < val || val < cur.next.val) {
						ListNode newNode = new ListNode(val);
						tmp = cur.next;
						cur.next = newNode;
						newNode.next = tmp;
						break;
					}
				} else {
					if (cur.next == head) {
						ListNode newNode = new ListNode(val);
						tmp = cur.next;
						cur.next = newNode;
						newNode.next = tmp;
						break;
					}
				}
			cur = cur.next;
			}
		return head;
	}
}
