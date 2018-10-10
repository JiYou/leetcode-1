package com.leetcode.list;

import common.ListNode;

/**
 * Created by lhcxx on 18/10/6.
 */
public class RemoveDuplicatesfromSortedListII_Leetcode82 {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null)
			return null;
		ListNode dummy = new ListNode();
		dummy.next = head;
		ListNode p = dummy;
		while (p.next != null && p.next.next != null) {
			if (p.next.val == p.next.next.val) {
				int val = p.next.val;
				while (p.next != null && p.next.val == val)
						p.next = p.next.next;
			} else
				p = p.next;
		}
		return dummy.next;
	}
}
