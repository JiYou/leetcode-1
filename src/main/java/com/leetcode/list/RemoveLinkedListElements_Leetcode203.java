package com.leetcode.list;

import com.leetcode.common.ListNode;

/**
 * Created by lhcxx on 18/10/2.
 */
public class RemoveLinkedListElements_Leetcode203 {
	public ListNode removeNode(ListNode head, int val) {
		if (head == null || head.next == null)
			return null;
		ListNode dummy = new ListNode();
		dummy.next = head;
		ListNode p = dummy;
		while (p.next != null) {
			if (p.next.val == val)
				p.next = p.next.next;
			else
				p = p.next;
		}
		return dummy.next;
	}
}
