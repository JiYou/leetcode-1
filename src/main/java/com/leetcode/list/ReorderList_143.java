package com.leetcode.list;

import common.ListNode;

public class ReorderList_143 {
	public void reorderList(ListNode head) {
		if (head == null || head.next == null)
			return;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode tmp = getMiddle(head);
		ListNode middle = tmp.next;
		tmp.next = null;
		ListNode l2 = reverse(middle);
		merge(head, l2);
	}

	private ListNode getMiddle(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}

	private ListNode reverse(ListNode head) {
		ListNode prev = null;
		while (head != null) {
			ListNode tmp = head.next;
			head.next = prev;
			prev = head;
			head = tmp;
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
			l2.next = l1;
			l1 = n1;
			l2 = n2;
		}
	}
}
