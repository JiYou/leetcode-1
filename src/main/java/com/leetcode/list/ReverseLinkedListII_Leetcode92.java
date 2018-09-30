package com.leetcode.list;

import common.ListNode;

/**
 * Created by lhcxx on 18/9/27.
 */
public class ReverseLinkedListII_Leetcode92 {
	public ListNode reverseList(ListNode head, int m, int n) {
		ListNode dummy = new ListNode();
		dummy.next = head;
		ListNode pre = dummy;
		ListNode cur = head;

		for (int i = 1; i < m; i++) {
			cur = cur.next;
			pre = pre.next;
		}

		for (int i = 0; i < n - m; i++) {
			ListNode tmp = cur.next;
			cur.next = tmp.next;
			tmp.next = pre.next;
			pre.next = tmp;
		}

		return dummy.next;
	}
}
