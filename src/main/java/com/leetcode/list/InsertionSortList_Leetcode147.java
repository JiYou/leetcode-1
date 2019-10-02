package com.leetcode.list;

import com.leetcode.common.ListNode;

/**
 * Created by lhcxx on 18/9/26.
 */
public class InsertionSortList_Leetcode147 {
	public ListNode insertionSortList(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode dummy = new ListNode();
		dummy.next = head;
		ListNode cur = head;
		ListNode tmp = null, prev = null;
		while (cur != null && cur.next != null) {
			if (cur.val < cur.next.val)
				cur = cur.next;
			else {
				tmp = cur.next;
				cur = cur.next;
				prev =dummy;
				while (prev.next.val <= tmp.val)
					prev = prev.next;
				prev.next = tmp;
				tmp.next = prev.next;
			}
		}
		return dummy.next;
	}

	public ListNode insertionSort(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode cur = head;
		ListNode tmp = null, prev = null;

		while (cur != null && cur.next != null) {
			if (cur.val < cur.next.val)
				cur = cur.next;
			else {
				tmp = cur.next;
				cur.next = tmp.next;
				prev = dummy;
				while (prev.next.val < tmp.val)
					prev = prev.next;
				tmp.next = prev.next;
				prev.next = tmp;
			}
		}
		return dummy;
	}
}
