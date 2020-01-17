package leetcode;

import com.leetcode.common.ListNode;

public class _369_PlusOne {
	public ListNode plusOne(ListNode head) {
		ListNode reverse = reverse(head);

		ListNode cur = reverse;
		cur.val += 1;
		int carry = 0;
		while (cur != null) {
			int x = cur.val + carry;
			carry = x / 10;
			cur.val = x % 10;
			cur = cur.next;
		}

		ListNode res = reverse(reverse);
		ListNode dummy = new ListNode(0);
		dummy.next = res;
		if (carry > 0) {
			ListNode tmp = new ListNode(1);
			tmp.next = dummy.next;
			dummy.next = tmp;
		}
		return dummy.next;
	}

	private ListNode reverse(ListNode head) {
		ListNode cur = head, pre = null;

		while (cur != null) {
			ListNode next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		return pre;
	}
}
