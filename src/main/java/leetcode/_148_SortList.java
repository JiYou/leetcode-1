package leetcode;

import com.leetcode.common.ListNode;

public class _148_SortList {
	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode mid = getMiddle(head);
		ListNode next = mid.next;
		mid.next = null;
		return merge(sortList(head), sortList(next));
	}

	private ListNode getMiddle(ListNode head) {
		ListNode slow = head, fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}

	private ListNode merge(ListNode a, ListNode b) {
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		while (a != null || b != null) {
			if (a.val < b.val) {
				cur.next = a;
				a = a.next;
			} else {
				cur.next = b;
				b = b.next;
			}
			cur = cur.next;
		}
		if (a != null)
			cur.next = a;
		else
			cur.next = b;
		return dummy.next;
	}
}
