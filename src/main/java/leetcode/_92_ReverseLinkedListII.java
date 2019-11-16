package leetcode;

import com.leetcode.common.ListNode;

public class _92_ReverseLinkedListII {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode cur = dummy.next, pre = dummy;

		for (int i = 1; i < m; i++) {
			pre = pre.next;
			cur = cur.next;
		}

		for (int i = 0; i < n - m; i++) {
			ListNode temp = cur.next;
			cur.next = temp.next;
			temp.next = pre.next;
			pre.next = temp;
		}

		return dummy.next;
	}
}
