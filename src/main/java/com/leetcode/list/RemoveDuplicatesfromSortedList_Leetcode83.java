package com.leetcode.list;

import com.leetcode.common.ListNode;

/**
 * Created by lhcxx on 18/10/6.
 */
public class RemoveDuplicatesfromSortedList_Leetcode83 {
	public ListNode deleteDuplicates(ListNode head) {
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
