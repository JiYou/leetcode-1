package leetcode;

import com.leetcode.common.ListNode;

import java.util.Random;

public class _382_LinkedListRandomNode {
	private ListNode head;
	private Random rdm;

	public _382_LinkedListRandomNode(ListNode head) {
		this.head = head;
		rdm = new Random();
	}

	public int getRandom() {
		ListNode tmp = head;
		int res = tmp.val;
		int i = 1;
		while (tmp.next != null) {
			tmp = tmp.next;
			if (rdm.nextInt(++i) == 0)
				res = tmp.val;
		}
		return res;
	}
}
