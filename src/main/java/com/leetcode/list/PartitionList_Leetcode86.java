package com.leetcode.list;

import com.leetcode.common.ListNode;

/**
 * Created by lhcxx on 18/10/22.
 */
public class PartitionList_Leetcode86 {
	public ListNode partition(ListNode head, int k) {
		ListNode smallHead = new ListNode(), bigHead = new ListNode(), small = smallHead, big = bigHead;
		while (head != null) {
			ListNode tmp = new ListNode(head.val);
			if (head.val < k) {
				small.next = tmp;
				small = small.next;
			} else {
				big.next = tmp;
				big = big.next;
			}
			head = head.next;
		}
		small.next = bigHead.next;
		return smallHead.next;
	}
}
