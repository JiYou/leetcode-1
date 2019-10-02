package com.leetcode.list;

import com.leetcode.common.ListNode;

/**
 * Created by lhcxx on 18/10/6.
 */
public class IntersectionofTwoLinkedLists_Leetcode160 {
	public ListNode getIntersectionNode(ListNode head1, ListNode head2) {
		if (head1 == null || head2 == null)
			return null;
		int len1 = len(head1);
		int len2 = len(head2);
		if (len1 > len2)
			for (int i = 0; i < len1 - len2; i++)
				head1 = head1.next;
		else
			for (int i = 0; i < len2 - len1; i++)
				head2 = head2.next;
		while (head1 != head2) {
			head1 = head1.next;
			head2 = head2.next;
		}
		return head1;
	}

	private int len(ListNode head) {
		int len = 1;
		while (head != null) {
			head = head.next;
			len++;
		}
		return len;
	}
}
