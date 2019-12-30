package leetcode;

import com.leetcode.common.ListNode;

public class _86_PartitionList {
	public ListNode partition(ListNode head, int x) {
		ListNode smallHead = new ListNode(0),
			bigHead = new ListNode(0),
			small = smallHead, big = bigHead;
		while (head != null) {
			ListNode tmp = new ListNode(head.val);
			if (head.val < x) {
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

	public ListNode partition2(ListNode head, int x) {
		ListNode bigHead = new ListNode(0),
			smallHead = new ListNode(0),
			big = bigHead, small = smallHead;
		while (head != null) {
			if (head.val < x) {
				small.next = head;
				small = small.next;
			} else {
				big.next = head;
				big = big.next;
			}
			head = head.next;
		}
		big.next = null;
		small.next = bigHead.next;
		return smallHead.next;
	}
}
