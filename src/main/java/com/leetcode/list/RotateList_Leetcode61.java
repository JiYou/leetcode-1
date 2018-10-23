package com.leetcode.list;

import common.ListNode;

/**
 * Created by lhcxx on 18/10/22.
 */
public class RotateList_Leetcode61 {
	public ListNode rotateRight(ListNode head, int k) {
		if (head == null || head.next == null)
			return null;
		int len = 1;
		ListNode cur = head;
		while (cur.next != null) {
			cur = cur.next;
			len++;
		}
		cur.next = head;
		for (int i = 1; i < len - k % len; i++) {
			head = head.next;
		}
		ListNode res = head.next;
		head.next = null;
		return res;
	}
}
