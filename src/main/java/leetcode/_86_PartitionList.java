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
}
