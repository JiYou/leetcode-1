package com.leetcode.list;

import java.util.HashMap;

public class CopyListWithRandomPointer_138 {
	public RandomListNode copy(RandomListNode head) {
		if (head == null)
			return head;
		HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
		RandomListNode node = head;

		while (node != null) {
			map.put(node, new RandomListNode(node.label));
			node = node.next;
		}

		RandomListNode cur = head;
		while (cur != null) {
			map.get(cur).next = map.get(cur.next);
			map.get(cur).random = map.get(cur.random);
			cur = cur.next;
		}

		return map.get(head);
	}

	public RandomListNode copy2(RandomListNode head) {
		if (head == null) return head;
		RandomListNode cur = head;
		while (cur != null) {
			
		}
	}
}
