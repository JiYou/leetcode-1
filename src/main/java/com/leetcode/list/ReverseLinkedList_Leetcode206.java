package com.leetcode.list;

import common.ListNode;

/**
 * Created by lhcxx on 18/9/27.
 */
public class ReverseLinkedList_Leetcode206 {
	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode pre = null;
		while (head != null) {
			ListNode tmp = head.next;
			head.next = pre;
			pre = head;
			head = tmp;
		}
		return pre;
	}
}
