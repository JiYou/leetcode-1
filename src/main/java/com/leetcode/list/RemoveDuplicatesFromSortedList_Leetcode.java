package com.leetcode.list;

import com.leetcode.common.ListNode;

/**
 * Created by lhcxx on 18/10/3.
 */
public class RemoveDuplicatesFromSortedList_Leetcode {
	public ListNode removeDuplicates(ListNode head) {
		if (head == null || head.next == null)
			return null;
		ListNode cur = head;
		while (cur.next != null) {
			if (cur.next.val == cur.val)
				cur.next = cur.next.next;
			else
				cur = cur.next;
		}
		return head;
	}
}
