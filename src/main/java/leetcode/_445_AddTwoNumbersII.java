package leetcode;

import com.leetcode.common.ListNode;

import java.util.Stack;

public class _445_AddTwoNumbersII {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		Stack<Integer> s1 = new Stack<>();
		Stack<Integer> s2 = new Stack<>();
		while (l1 != null)
			s1.push(l1.val);
		while (l2 != null)
			s2.push(l2.val);
		ListNode cur = new ListNode(0);
		int sum = 0;

		while (!s1.isEmpty() || !s2.isEmpty()) {
			if (!s1.isEmpty()) sum += s1.pop();
			if (!s2.isEmpty()) sum += s2.pop();
			cur.val = sum % 10;
			ListNode head = new ListNode(sum / 10);
			head.next = cur;
			sum /= 10;
			cur = head;
		}
		return cur.val == 0 ? cur.next:cur;
	}
}
