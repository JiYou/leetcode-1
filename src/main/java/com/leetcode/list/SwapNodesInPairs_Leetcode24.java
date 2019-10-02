package com.leetcode.list;

import com.leetcode.common.ListNode;

/**
 * Created by lhcxx on 18/10/2.
 */


// 1->2->3->4   2->1->4->3
public class SwapNodesInPairs_Leetcode24 {
	public ListNode swapPair(ListNode head) {
		if (head == null || head.next == null)
			return null;
		ListNode dummy = new ListNode();
		dummy.next = head;

		ListNode l1 = dummy;
		ListNode l2 = head;
		while (l2 != null && l2.next != null) {
			ListNode next = l2.next.next;
			l1.next = l2;
			l2.next.next = l2;
			l2.next = next;
			l1 = l2;
			l2 = l2.next;
		}
		return dummy.next;
	}
}
