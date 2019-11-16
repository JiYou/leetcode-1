package leetcode;

import com.leetcode.common.ListNode;

public class _19_RemoveNthNodeFromEndofList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode fast = head, slow = head;
		for(int i = 0; i < n; i++)
			fast = fast.next;
		while (fast != null) {
			fast = fast.next;
			slow = slow.next;
		}
		slow.next = slow.next.next;
		return dummy.next;
	}
}
