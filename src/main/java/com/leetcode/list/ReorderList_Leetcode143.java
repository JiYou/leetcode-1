package com.leetcode.list;

import com.leetcode.common.ListNode;

/**
 * Created by lhcxx on 18/10/2.
 */
public class ReorderList_Leetcode143 {
	public void reorderList(ListNode head) {
		if (head == null || head.next == null)
			return;
		ListNode fast = head, slow = head, l1 = head;
		ListNode tmp = null;

		while (fast != null && fast.next != null) {
			tmp = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		tmp.next = null;
		ListNode l2 = reverse(slow);
		merge(l1, l2);
	}


	private ListNode reverse(ListNode head) {
		if(head == null || head.next == null)
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

	private void merge(ListNode l1, ListNode l2) {
		while (l1 != l2) {
			ListNode n1 = l1.next;
			ListNode n2 = l2.next;
			l1.next = l2;
			if (n1 == null)
				break;
			l2.next = n1;
			l1 = n1;
			l2 = n2;
		}
	}
}
