package com.leetcode.list;

import com.leetcode.common.ListNode;

/**
 * Created by lhcxx on 18/10/6.
 */
public class AddTwoNumbers_Leetcode2 {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode();
		int sum = 0;
		ListNode cur = dummy;
		ListNode p1 = l1, p2 = l2;
		while (p1 != null || p2 != null) {
			if (p1 != null) {
				sum += p1.val;
				p1 = p1.next;
			}
			if (p2 != null) {
				sum += p2.val;
				p2 = p2.next;
			}
		  cur.next = new ListNode(sum % 10);
			sum /= 10;
			cur = cur.next;
		}
		if (sum == 1)
			cur.next = new ListNode(1);
		return dummy.next;
	}

	public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode();
		ListNode p1 = l1, p2 = l2, cur = dummy;
		int sum = 0;
		while (p1 != null || p2 != null) {
			if (p1 != null) {
				sum += p1.val;
				p1 = p1.next;
			}
			if (p2 != null) {
				sum += p2.val;
				p2 = p2.next;
			}
			cur = new ListNode(sum % 10);
			sum /= 10;
			cur = cur.next;
		}
		if (sum == 1)
			cur.next = new ListNode(1);
		return dummy.next;
	}
}
