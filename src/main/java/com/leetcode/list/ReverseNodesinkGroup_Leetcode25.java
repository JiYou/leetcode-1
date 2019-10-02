package com.leetcode.list;

import com.leetcode.common.ListNode;

/**
 * Created by lhcxx on 18/10/22.
 */
public class ReverseNodesinkGroup_Leetcode25 {
	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || head.next == null)
			return null;
		int count = 0;
		ListNode cur = head;
		while (cur != null && count != k) {
			cur = cur.next;
			count++;
		}
		if (count == k) {
			cur = reverseKGroup(cur, k);
			while (count-- > 0) {
				ListNode next = head.next;
				head.next = cur;
				cur = head;
				head = next;
			}
			head = cur;
		}
		return head;
	}
}
