package com.leetcode.list;

import com.leetcode.common.ListNode;

public class MergerTwoSortedList {
	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode mid = getMidNode(head);
		ListNode next = mid.next;
		mid.next = null;
		return merge(sortList(head), sortList(next));
	}

	private ListNode getMidNode(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	private ListNode merge(ListNode a, ListNode b) {
		ListNode dummy = new ListNode();
		ListNode cur = dummy;
		while (a != null && b != null) {
			if (a.val < b.val) {
				cur.next = a;
				a = a.next;
			} else {
				cur.next = b;
				b = b.next;
			}
		}

		if (a != null)
			cur.next = a;
		else
			cur.next = b;
		return dummy.next;
	}
}
