package com.leetcode.list;

import com.leetcode.common.ListNode;

/**
 * Created by lhcxx on 18/9/27.
 */
public class MergeTwoSortedLists_Leetcode21 {
	public ListNode mergeTwoList(ListNode head1, ListNode head2) {
		ListNode dummy = new ListNode();
		ListNode cur = dummy;

		while (head1 != null && head2 != null) {
			if (head1.val < head2.val) {
				cur.next = new ListNode(head1.val);
				head1 = head1.next;
			} else {
				cur.next = new ListNode(head2.val);
				head2 = head2.next;
			}
			cur = cur.next;
		}
		if (head1 != null)
			cur.next = head1;
		if (head2 != null)
			cur.next = head2;
		return dummy.next;
	}

	public ListNode mergeTwoList2(ListNode head1, ListNode head2) {
		if (head1 == null) return head2;
		if (head2 == null) return head1;
		if (head1.val < head2.val) {
			head1.next = mergeTwoList2(head1.next, head2);
			return head1;
		}
		else {
			head2.next = mergeTwoList2(head1, head2.next);
			return head2;
		}
	}
}
