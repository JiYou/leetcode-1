package leetcode;

import com.leetcode.common.ListNode;

public class _142_LinkedListCycleII {
	public ListNode detectCycle(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode fast = head, slow = head;

		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;

			if (fast == slow) {
				ListNode slow2 = head;
				while (slow != slow2) {
					slow = slow.next;
					slow2 = slow2.next;
				}
				return slow;
			}
		}
		return null;
	}
}
