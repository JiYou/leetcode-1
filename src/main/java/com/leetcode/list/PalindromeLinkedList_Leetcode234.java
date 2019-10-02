package com.leetcode.list;

import com.leetcode.common.ListNode;

/**
 * Created by lhcxx on 18/10/21.
 */
public class PalindromeLinkedList_Leetcode234 {
	public boolean isPalindrome(ListNode head) {
		if (head == null) return true;
		ListNode mid = findMiddle(head);
		mid.next = reverseList(mid.next);

		ListNode p = head;
		ListNode q = mid.next;
		while (p != null && q != null) {
			if (p.val != q.val)
				return false;
			p = p.next;
			q = q.next;
		}
		return true;
	}

	private ListNode findMiddle(ListNode head) {
		ListNode slow = head, fast = head.next;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	private ListNode reverseList(ListNode head) {
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
